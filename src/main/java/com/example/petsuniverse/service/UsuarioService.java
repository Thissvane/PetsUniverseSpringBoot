package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Usuario;
import com.example.petsuniverse.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Usuario}. Almacena la clave siempre cifrada con BCrypt.
 */
@Service
public class UsuarioService extends CrudService<Usuario, Integer> {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
        this.usuarioRepository = repository;
    }

    /**
     * Guarda el usuario. Si es una edición y la clave llega vacía, conserva la clave actual;
     * si llega en texto plano, la cifra antes de persistir.
     */
    @Override
    public Usuario guardar(Usuario usuario) {
        boolean claveVacia = usuario.getClave() == null || usuario.getClave().isBlank();
        if (claveVacia && usuario.getIdUsuario() != null) {
            usuarioRepository.findById(usuario.getIdUsuario())
                    .ifPresent(actual -> usuario.setClave(actual.getClave()));
        } else if (!claveVacia && !estaCifrada(usuario.getClave())) {
            usuario.setClave(encoder.encode(usuario.getClave()));
        }
        return super.guardar(usuario);
    }

    private boolean estaCifrada(String clave) {
        return clave.startsWith("$2a$") || clave.startsWith("$2b$") || clave.startsWith("$2y$");
    }
}

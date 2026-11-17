package com.example.petsuniverse.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio base con las operaciones CRUD comunes a todas las entidades.
 *
 * @param <T>  tipo de entidad
 * @param <ID> tipo de la clave primaria
 */
public abstract class CrudService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    protected CrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> listar() {
        return repository.findAll();
    }

    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }

    public T guardar(T entidad) {
        return repository.save(entidad);
    }

    public void eliminar(ID id) {
        repository.deleteById(id);
    }
}

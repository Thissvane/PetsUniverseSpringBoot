package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="raza")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombreEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;

}

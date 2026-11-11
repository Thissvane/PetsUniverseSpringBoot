package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;
}
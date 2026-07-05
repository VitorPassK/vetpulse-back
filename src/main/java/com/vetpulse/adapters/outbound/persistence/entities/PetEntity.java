package com.vetpulse.adapters.outbound.persistence.entities;

import com.vetpulse.domain.models.Especie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class PetEntity {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especie especie;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "tutor_id", nullable = false, columnDefinition = "uuid")
    private UUID tutorId;

    public PetEntity(UUID id, String nome, Especie especie, LocalDate dataNascimento, UUID tutorId) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.dataNascimento = dataNascimento;
        this.tutorId = tutorId;
    }
}

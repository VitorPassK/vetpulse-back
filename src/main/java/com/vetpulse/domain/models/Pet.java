package com.vetpulse.domain.models;

import lombok.Getter;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Pet {
    private final UUID id;
    private String nome;
    private final Especie especie;
    private final LocalDate dataNascimento;
    private final UUID tutorId;

    public Pet(UUID id, String nome, Especie especie, LocalDate dataNascimento, UUID tutorId, Clock clock) {
        if (especie == null) {
            throw new IllegalArgumentException("Espécie é obrigatória");
        }
        if (dataNascimento != null && dataNascimento.isAfter(LocalDate.now(clock))) {
            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro");
        }
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.dataNascimento = dataNascimento;
        this.tutorId = tutorId;
    }
    public void renomear(String novoNome) {
        if (novoNome == null || novoNome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = novoNome;
    }

    public Integer calcularIdadeEmAnos(Clock clock) {
        if (dataNascimento == null) {
            return null;
        }
        return Period.between(dataNascimento, LocalDate.now(clock)).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

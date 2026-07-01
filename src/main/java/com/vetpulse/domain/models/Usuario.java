package com.vetpulse.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Usuario {

    @EqualsAndHashCode.Include
    private final UUID id;

    private String nome;
    private final String email;
    private final String senhaHash;

    protected Usuario(UUID id, String nome, String email, String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    public void renomear(String novoNome) {
        if (novoNome == null || novoNome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = novoNome;
    }

    public abstract String getRole();
}

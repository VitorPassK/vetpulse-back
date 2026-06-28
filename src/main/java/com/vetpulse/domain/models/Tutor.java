package com.vetpulse.domain.models;

import lombok.Getter;

@Getter
public class Tutor extends Usuario{
    private String telefone;

    public Tutor (String id, String nome, String email, String senhaHash, String telefone) {
        super(id, nome, email, senhaHash);
        this.telefone = telefone;
    }

    public void atualizarTelefone(String novoTelefone) {
        if (novoTelefone == null || novoTelefone.isBlank()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }
        this.telefone = novoTelefone;
    }

    @Override
    public String getRole() {
        return "TUTOR";
    }
}

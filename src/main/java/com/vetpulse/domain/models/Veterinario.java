package com.vetpulse.domain.models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Veterinario extends Usuario{
    private final String crmv;

    public Veterinario(UUID id, String nome, String email, String senhaHash, String crmv) {
        super(id, nome, email, senhaHash);
        this.crmv = crmv;
    }

    @Override
    public String getRole(){
        return "VETERINARIO";
    }
}

package com.vetpulse.adapters.inbound.dto.veterinario;

import com.vetpulse.domain.models.Veterinario;

import java.util.UUID;

public record VeterinarioResponse(
        UUID id,
        String nome,
        String email,
        String crmv
) {
    public static VeterinarioResponse from(Veterinario veterinario) {
        return new VeterinarioResponse(
                veterinario.getId(),
                veterinario.getNome(),
                veterinario.getEmail(),
                veterinario.getCrmv()
        );
    }
}

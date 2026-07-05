package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Veterinario;

import java.util.Optional;
import java.util.UUID;

public interface VeterinarioRepositoryPort {

    Optional<Veterinario> buscarPorId(UUID id);

    Optional<Veterinario> buscarPorCrmv(String crmv);

    Optional<Veterinario> buscarPorEmail(String email);

    Veterinario salvar(Veterinario veterinario);
}

package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Veterinario;

import java.util.Optional;

public interface VeterinarioRepositoryPort {

    Optional<Veterinario> buscarPorId(String id);

    Optional<Veterinario> buscarPorCrmv(String crmv);

    Veterinario salvar(Veterinario veterinario);
}

package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Veterinario;

public interface CriarVeterinarioUseCase {

    Veterinario criar(String nome, String email, String senhaEmTextoPuro, String crmv);
    
}

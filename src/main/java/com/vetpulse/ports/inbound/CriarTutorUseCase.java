package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Tutor;

public interface CriarTutorUseCase {

    Tutor criar(String nome, String email, String senhaEmTextoPuro, String telefone);

}

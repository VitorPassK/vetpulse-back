package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Tutor;

import java.util.Optional;

public interface TutorRepositoryPort {

    Optional<Tutor> buscarPorId(String id);

    Optional<Tutor> buscarPorEmail(String email);

    Tutor salvar(Tutor tutor);
    
}

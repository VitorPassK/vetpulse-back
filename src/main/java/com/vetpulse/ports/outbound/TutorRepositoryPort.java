package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Tutor;

import java.util.Optional;
import java.util.UUID;

public interface TutorRepositoryPort {

    Optional<Tutor> buscarPorId(UUID id);

    Optional<Tutor> buscarPorEmail(String email);

    Tutor salvar(Tutor tutor);
    
}

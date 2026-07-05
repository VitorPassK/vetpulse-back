package com.vetpulse.adapters.inbound.dto.tutor;

import com.vetpulse.domain.models.Tutor;

import java.util.UUID;

public record TutorResponse(
        UUID id,
        String nome,
        String email,
        String telefone
) {

    public static TutorResponse from(Tutor tutor) {
        return new TutorResponse(
                tutor.getId(),
                tutor.getNome(),
                tutor.getEmail(),
                tutor.getTelefone()
        );
    }

}

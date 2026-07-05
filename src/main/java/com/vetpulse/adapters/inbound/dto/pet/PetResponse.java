package com.vetpulse.adapters.inbound.dto.pet;

import com.vetpulse.domain.models.Especie;
import com.vetpulse.domain.models.Pet;

import java.time.Clock;
import java.time.LocalDate;
import java.util.UUID;

public record PetResponse(
        UUID id,
        String nome,
        Especie especie,
        LocalDate dataNascimento,
        Integer idadeEmAnos,
        UUID tutorId
) {
    public static PetResponse from(Pet pet, Clock clock) {
        return new PetResponse(
                pet.getId(),
                pet.getNome(),
                pet.getEspecie(),
                pet.getDataNascimento(),
                pet.calcularIdadeEmAnos(clock),
                pet.getTutorId()
        );
    }
}

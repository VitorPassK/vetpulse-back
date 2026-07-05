package com.vetpulse.adapters.inbound.dto.pet;

import com.vetpulse.domain.models.Especie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CriarPetRequest(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Espécie é obrigatória")
        Especie especie,

        LocalDate dataNascimento,

        @NotNull(message = "Id do tutor é obrigatório")
        UUID tutorId
) {}

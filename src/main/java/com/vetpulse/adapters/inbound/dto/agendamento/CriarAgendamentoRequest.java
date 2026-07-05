package com.vetpulse.adapters.inbound.dto.agendamento;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record CriarAgendamentoRequest(

        @NotNull(message = "Id do pet é obrigatório")
        UUID petId,

        @NotNull(message = "Id do tutor é obrigatório")
        UUID tutorId,

        @NotNull(message = "Id do veterinário é obrigatório")
        UUID veterinarioId,

        @NotNull(message = "Horário é obrigatório")
        @Future(message = "O horário deve ser no futuro")
        LocalDateTime horario
) {}

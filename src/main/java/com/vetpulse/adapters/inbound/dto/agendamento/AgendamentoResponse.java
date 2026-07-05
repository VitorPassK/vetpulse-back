package com.vetpulse.adapters.inbound.dto.agendamento;

import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.domain.models.StatusAgendamento;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponse(
        UUID id,
        UUID petId,
        UUID tutorId,
        UUID veterinarioId,
        LocalDateTime horario,
        StatusAgendamento status
) {
    public static AgendamentoResponse from(Agendamento agendamento) {
        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getPetId(),
                agendamento.getTutorId(),
                agendamento.getVeterinarioId(),
                agendamento.getHorario(),
                agendamento.getStatus()
        );
    }
}

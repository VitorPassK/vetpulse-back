package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Agendamento;

import java.time.LocalDateTime;

public interface CriarAgendamentoUseCase {

    Agendamento criar(String petId, String tutorId, String veterinarioId, LocalDateTime horario);
}

package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Agendamento;

import java.time.LocalDateTime;
import java.util.UUID;

public interface CriarAgendamentoUseCase {

    Agendamento criar(UUID petId, UUID tutorId, UUID veterinarioId, LocalDateTime horario);
}

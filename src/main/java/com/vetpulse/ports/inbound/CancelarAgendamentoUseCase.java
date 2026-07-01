package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Agendamento;

import java.util.UUID;

public interface CancelarAgendamentoUseCase {

    Agendamento cancelar(UUID agendamentoId);
}

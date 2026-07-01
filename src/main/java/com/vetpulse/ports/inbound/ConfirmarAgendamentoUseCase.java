package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Agendamento;

import java.util.UUID;

public interface ConfirmarAgendamentoUseCase {

    Agendamento confirmar(UUID agendamentoId);
}

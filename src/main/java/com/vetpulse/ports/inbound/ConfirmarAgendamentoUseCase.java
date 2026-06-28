package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Agendamento;

public interface ConfirmarAgendamentoUseCase {

    Agendamento confirmar(String agendamentoId);
}

package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Agendamento;

public interface CancelarAgendamentoUseCase {

    Agendamento cancelar(String agendamentoId);
}

package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Agendamento;

public interface RealizarAgendamentoUseCase {

    Agendamento realizar(String agendamentoId);
}

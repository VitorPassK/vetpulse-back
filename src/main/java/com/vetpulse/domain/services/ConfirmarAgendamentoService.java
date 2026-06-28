package com.vetpulse.domain.services;

import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.ports.inbound.ConfirmarAgendamentoUseCase;
import com.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmarAgendamentoService implements ConfirmarAgendamentoUseCase {

    private final AgendamentoRepositoryPort agendamentoRepository;

    @Override
    public Agendamento confirmar(String agendamentoId) {
        Agendamento agendamento = agendamentoRepository.buscarPorId(agendamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado: " + agendamentoId));

        agendamento.confirmar();

        return agendamentoRepository.salvar(agendamento);
    }
}

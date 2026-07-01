package com.vetpulse.domain.services;

import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.ports.inbound.ConfirmarAgendamentoUseCase;
import com.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ConfirmarAgendamentoService implements ConfirmarAgendamentoUseCase {

    private final AgendamentoRepositoryPort agendamentoRepository;

    @Override
    public Agendamento confirmar(UUID agendamentoId) {
        Agendamento agendamento = agendamentoRepository.buscarPorId(agendamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado: " + agendamentoId));

        agendamento.confirmar();

        return agendamentoRepository.salvar(agendamento);
    }
}

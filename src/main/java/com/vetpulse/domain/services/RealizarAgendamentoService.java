package com.vetpulse.domain.services;

import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.ports.inbound.RealizarAgendamentoUseCase;
import com.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class RealizarAgendamentoService implements RealizarAgendamentoUseCase {

    private final AgendamentoRepositoryPort agendamentoRepository;

    @Override
    public Agendamento realizar(UUID agendamentoId) {
        Agendamento agendamento = agendamentoRepository.buscarPorId(agendamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado: " + agendamentoId));

        agendamento.realizar();

        return agendamentoRepository.salvar(agendamento);
    }
}

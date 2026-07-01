package com.vetpulse.domain.services;

import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.ports.inbound.CancelarAgendamentoUseCase;
import com.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CancelarAgendamentoService implements CancelarAgendamentoUseCase {

    private final AgendamentoRepositoryPort agendamentoRepository;

    @Override
    public Agendamento cancelar(UUID agendamentoId) {
        Agendamento agendamento = agendamentoRepository.buscarPorId(agendamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado: " + agendamentoId));

        agendamento.cancelar();

        return agendamentoRepository.salvar(agendamento);
    }
}

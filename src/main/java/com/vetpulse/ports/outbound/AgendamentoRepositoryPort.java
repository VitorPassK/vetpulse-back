package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Agendamento;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AgendamentoRepositoryPort {
    
    Optional<Agendamento> buscarPorVeterinarioEHorario(String veterinarioId, LocalDateTime horario);

    Agendamento salvar(Agendamento agendamento);

    Optional<Agendamento> buscarPorId(String id);
}

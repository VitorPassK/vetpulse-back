package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Agendamento;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface AgendamentoRepositoryPort {
    
    Optional<Agendamento> buscarPorVeterinarioEHorario(UUID veterinarioId, LocalDateTime horario);

    Agendamento salvar(Agendamento agendamento);

    Optional<Agendamento> buscarPorId(UUID id);
}

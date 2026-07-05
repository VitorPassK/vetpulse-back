package com.vetpulse.adapters.outbound.persistence.adapters;

import com.vetpulse.adapters.outbound.persistence.entities.AgendamentoEntity;
import com.vetpulse.adapters.outbound.persistence.repositories.AgendamentoJpaRepository;
import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AgendamentoRepositoryAdapter implements AgendamentoRepositoryPort {

    private final AgendamentoJpaRepository jpaRepository;

    @Override
    @Transactional
    public Optional<Agendamento> buscarPorVeterinarioEHorario(UUID veterinarioId,
                                                              LocalDateTime horario) {
        return jpaRepository
                .buscarPorVeterinarioEHorarioComLock(veterinarioId, horario)
                .map(this::toDomain);
    }

    @Override
    public Optional<Agendamento> buscarPorId(UUID id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        AgendamentoEntity entity = toEntity(agendamento);
        AgendamentoEntity salvo = jpaRepository.save(entity);
        return toDomain(salvo);
    }

    private Agendamento toDomain(AgendamentoEntity entity) {
        return Agendamento.reconstituir(
                entity.getId(),
                entity.getPetId(),
                entity.getTutorId(),
                entity.getVeterinarioId(),
                entity.getHorario(),
                entity.getStatus()
        );
    }

    private AgendamentoEntity toEntity(Agendamento agendamento) {
        return new AgendamentoEntity(
                agendamento.getId(),
                agendamento.getPetId(),
                agendamento.getTutorId(),
                agendamento.getVeterinarioId(),
                agendamento.getHorario(),
                agendamento.getStatus()
        );
    }
}

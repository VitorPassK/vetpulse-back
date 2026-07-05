package com.vetpulse.adapters.outbound.persistence.repositories;

import com.vetpulse.adapters.outbound.persistence.entities.AgendamentoEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoEntity, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM AgendamentoEntity a " +
            "WHERE a.veterinarioId = :veterinarioId " +
            "AND a.horario = :horario")
    Optional<AgendamentoEntity> buscarPorVeterinarioEHorarioComLock(
            @Param("veterinarioId") UUID veterinarioId,
            @Param("horario") LocalDateTime horario);
}

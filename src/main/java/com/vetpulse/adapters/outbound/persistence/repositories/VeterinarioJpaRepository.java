package com.vetpulse.adapters.outbound.persistence.repositories;

import com.vetpulse.adapters.outbound.persistence.entities.VeterinarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VeterinarioJpaRepository extends JpaRepository<VeterinarioEntity, UUID> {

    Optional<VeterinarioEntity> findByEmail(String email);

    Optional<VeterinarioEntity> findByCrmv(String crmv);
}

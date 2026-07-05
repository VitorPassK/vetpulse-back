package com.vetpulse.adapters.outbound.persistence.repositories;

import com.vetpulse.adapters.outbound.persistence.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TutorJpaRepository extends JpaRepository<TutorEntity, UUID> {

    Optional<TutorEntity> findByEmail(String email);

}

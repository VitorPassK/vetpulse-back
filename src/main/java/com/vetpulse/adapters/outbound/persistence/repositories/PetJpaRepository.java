package com.vetpulse.adapters.outbound.persistence.repositories;

import com.vetpulse.adapters.outbound.persistence.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PetJpaRepository extends JpaRepository<PetEntity, UUID> {

    List<PetEntity> findByTutorId(UUID tutorId);

}

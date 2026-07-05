package com.vetpulse.adapters.outbound.persistence.adapters;

import com.vetpulse.adapters.outbound.persistence.entities.PetEntity;
import com.vetpulse.adapters.outbound.persistence.repositories.PetJpaRepository;
import com.vetpulse.domain.models.Pet;
import com.vetpulse.ports.outbound.PetRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PetRepositoryAdapter implements PetRepositoryPort {

    private final PetJpaRepository jpaRepository;
    private final Clock clock;

    @Override
    public Optional<Pet> buscarPorId(UUID id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Pet> buscarPorTutorId(UUID tutorId) {
        return jpaRepository.findByTutorId(tutorId)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Pet salvar(Pet pet) {
        PetEntity entity = toEntity(pet);
        PetEntity salvo = jpaRepository.save(entity);
        return toDomain(salvo);
    }

    private Pet toDomain(PetEntity entity) {
        return new Pet(
                entity.getId(),
                entity.getNome(),
                entity.getEspecie(),
                entity.getDataNascimento(),
                entity.getTutorId(),
                clock
        );
    }

    private PetEntity toEntity(Pet pet) {
        return new PetEntity(
                pet.getId(),
                pet.getNome(),
                pet.getEspecie(),
                pet.getDataNascimento(),
                pet.getTutorId()
        );
    }
}

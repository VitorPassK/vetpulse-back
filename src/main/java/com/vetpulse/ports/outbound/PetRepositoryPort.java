package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Pet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PetRepositoryPort {

    Optional<Pet> buscarPorId(UUID id);

    List<Pet> buscarPorTutorId(UUID tutorId);

    Pet salvar(Pet pet);

}

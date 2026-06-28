package com.vetpulse.ports.outbound;

import com.vetpulse.domain.models.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepositoryPort {

    Optional<Pet> buscarPorId(String id);

    List<Pet> buscarPorTutorId(String tutorId);

    Pet salvar(Pet pet);

}

package com.vetpulse.ports.inbound;

import com.vetpulse.domain.models.Especie;
import com.vetpulse.domain.models.Pet;

import java.time.LocalDate;
import java.util.UUID;

public interface CriarPetUseCase {

    Pet criar(String nome, Especie especie, LocalDate dataNascimento, UUID tutorId);

}

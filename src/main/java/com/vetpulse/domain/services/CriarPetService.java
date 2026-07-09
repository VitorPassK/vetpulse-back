package com.vetpulse.domain.services;

import com.vetpulse.domain.exceptions.RecursoNaoEncontradoException;
import com.vetpulse.domain.models.Especie;
import com.vetpulse.domain.models.Pet;
import com.vetpulse.ports.inbound.CriarPetUseCase;
import com.vetpulse.ports.outbound.PetRepositoryPort;
import com.vetpulse.ports.outbound.TutorRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
public class CriarPetService implements CriarPetUseCase {

    private final PetRepositoryPort petRepository;
    private final TutorRepositoryPort tutorRepository;
    private final Clock clock;

    @Override
    public Pet criar(String nome, Especie especie, LocalDate dataNascimento, UUID tutorId) {
        validarTutorExiste(tutorId);

        UUID novoId = UUID.randomUUID();
        Pet pet = new Pet(novoId, nome, especie, dataNascimento, tutorId, clock);

        return petRepository.salvar(pet);
    }

    private void validarTutorExiste(UUID tutorId) {
        tutorRepository.buscarPorId(tutorId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Tutor", tutorId));
    }
}

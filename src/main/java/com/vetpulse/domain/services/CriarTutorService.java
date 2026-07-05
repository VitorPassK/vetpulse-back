package com.vetpulse.domain.services;

import com.vetpulse.domain.models.Tutor;
import com.vetpulse.ports.inbound.CriarTutorUseCase;
import com.vetpulse.ports.outbound.PasswordHasherPort;
import com.vetpulse.ports.outbound.TutorRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CriarTutorService implements CriarTutorUseCase {

    private final TutorRepositoryPort tutorRepository;
    private final PasswordHasherPort passwordHasher;

    @Override
    public Tutor criar(String nome,String email, String senhaEmTextoPuro, String telefone) {
        validarEmailDisponivel(email);
        String senhaHash = passwordHasher.hash(senhaEmTextoPuro);
        UUID novoId = UUID.randomUUID();

        Tutor tutor = new Tutor(novoId, nome, email, senhaHash, telefone);

        return tutorRepository.salvar(tutor);
    }

    private void validarEmailDisponivel(String email) {
        tutorRepository.buscarPorEmail(email)
                .ifPresent(tutorExistente -> {
                    throw new IllegalArgumentException("Este email já está cadastrado em nosso sistema");
                });
    }

}

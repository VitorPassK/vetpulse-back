package com.vetpulse.domain.services;

import com.vetpulse.domain.models.Veterinario;
import com.vetpulse.ports.inbound.CriarVeterinarioUseCase;
import com.vetpulse.ports.outbound.PasswordHasherPort;
import com.vetpulse.ports.outbound.VeterinarioRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CriarVeterinarioService implements CriarVeterinarioUseCase {

    private final VeterinarioRepositoryPort veterinarioRepository;
    private final PasswordHasherPort passwordHasher;

    @Override
    public Veterinario criar(String nome, String email, String senhaEmTextoPuro, String crmv) {
        validarEmailDisponivel(email);
        validarCrmvDisponivel(crmv);

        String senhaHash = passwordHasher.hash(senhaEmTextoPuro);
        UUID novoId = UUID.randomUUID();

        Veterinario veterinario = new Veterinario(novoId, nome, email, senhaHash, crmv);

        return veterinarioRepository.salvar(veterinario);
    }

    private void validarCrmvDisponivel(String crmv) {
        veterinarioRepository.buscarPorCrmv(crmv)
                .ifPresent(v -> {
                    throw new IllegalArgumentException("Já existe um veterinário cadastrado com esse crmv.");
                });
    }

    private void validarEmailDisponivel(String email) {
        veterinarioRepository.buscarPorEmail(email)
                .ifPresent(v -> {
                    throw new IllegalArgumentException("Já existe um veteriário cadastrado com esse email.");
                });
    }
}

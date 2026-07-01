package com.vetpulse.domain.services;

import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.ports.inbound.CriarAgendamentoUseCase;
import com.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import com.vetpulse.ports.outbound.PetRepositoryPort;
import com.vetpulse.ports.outbound.VeterinarioRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class CriarAgendamentoService implements CriarAgendamentoUseCase {

    private final AgendamentoRepositoryPort agendamentoRepository;
    private final PetRepositoryPort petRepository;
    private final VeterinarioRepositoryPort veterinarioRepository;
    private final Clock clock;

    @Override
    public Agendamento criar(UUID petId, UUID tutorId, UUID veterinarioId, LocalDateTime horario) {
        validarPetExiste(petId);
        validarVeterinarioExiste(veterinarioId);
        validarDisponibilidade(veterinarioId, horario);

        UUID novoId = UUID.randomUUID();
        Agendamento agendamento = new Agendamento(novoId, petId, tutorId, veterinarioId, horario, clock);

        return agendamentoRepository.salvar(agendamento);
    }

    private void validarPetExiste(UUID petId) {
        petRepository.buscarPorId(petId)
                .orElseThrow(() -> new IllegalArgumentException("pet não encontrado: " + petId));
    }

    private void validarVeterinarioExiste(UUID veterinarioId) {
        veterinarioRepository.buscarPorId(veterinarioId)
                .orElseThrow(() -> new IllegalArgumentException("Veterinário não encontrado: " + veterinarioId));
    }

    private void validarDisponibilidade(UUID veterinarioId, LocalDateTime horario) {
        agendamentoRepository.buscarPorVeterinarioEHorario(veterinarioId, horario)
                .ifPresent(agendamentoExistente -> {
                    throw new IllegalStateException(
                            "Veterinário já possui um agendamento neste horário: " + horario);
                });
    }
}

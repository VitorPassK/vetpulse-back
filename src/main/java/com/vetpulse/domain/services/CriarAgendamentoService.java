package com.vetpulse.domain.services;

import com.vetpulse.domain.exceptions.AgendamentoConflitanteException;
import com.vetpulse.domain.exceptions.RecursoNaoEncontradoException;
import com.vetpulse.domain.models.Agendamento;
import com.vetpulse.ports.inbound.CriarAgendamentoUseCase;
import com.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import com.vetpulse.ports.outbound.PetRepositoryPort;
import com.vetpulse.ports.outbound.VeterinarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class CriarAgendamentoService implements CriarAgendamentoUseCase {

    private static final Logger log = LoggerFactory.getLogger(CriarAgendamentoService.class);

    private final AgendamentoRepositoryPort agendamentoRepository;
    private final PetRepositoryPort petRepository;
    private final VeterinarioRepositoryPort veterinarioRepository;
    private final Clock clock;

    @Override
    public Agendamento criar(UUID petId, UUID tutorId, UUID veterinarioId, LocalDateTime horario) {
        log.info("Iniciando criação de agendamento: petId={}, veterinarioId={}, horario={}",
                petId, veterinarioId, horario);

        validarPetExiste(petId);
        validarVeterinarioExiste(veterinarioId);
        validarDisponibilidade(veterinarioId, horario);

        UUID novoId = UUID.randomUUID();
        Agendamento agendamento = new Agendamento(novoId, petId, tutorId, veterinarioId, horario, clock);
        Agendamento salvo = agendamentoRepository.salvar(agendamento);

        log.info("Agendamento criado com sucesso: {}", salvo.getId());
        return agendamentoRepository.salvar(agendamento);
    }

    private void validarPetExiste(UUID petId) {
        petRepository.buscarPorId(petId)
                .orElseThrow(() -> {
                    log.warn("Tentativa de agendamento com pet inexistente: petId={}", petId);
                    return new RecursoNaoEncontradoException("Pet", petId);
                });
    }

    private void validarVeterinarioExiste(UUID veterinarioId) {
        veterinarioRepository.buscarPorId(veterinarioId)
                .orElseThrow(() -> {
                    log.warn("Tentativa de agendamento com veterinário inexistente: veterinarioId={}", veterinarioId);
                    return new RecursoNaoEncontradoException("Veterinário", veterinarioId);
                });
    }

    private void validarDisponibilidade(UUID veterinarioId, LocalDateTime horario) {
        agendamentoRepository.buscarPorVeterinarioEHorario(veterinarioId, horario)
                .ifPresent(agendamentoExistente -> {
                    log.warn("Overbooking bloqueado: veterinarioId={}, horario={}, agendamentoExistenteId={}",
                            veterinarioId, horario, agendamentoExistente.getId());
                    throw new AgendamentoConflitanteException(veterinarioId, horario);
                });
    }
}

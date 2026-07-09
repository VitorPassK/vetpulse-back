package com.vetpulse.adapters.inbound.rest;

import com.vetpulse.adapters.inbound.dto.agendamento.AgendamentoResponse;
import com.vetpulse.adapters.inbound.dto.agendamento.CriarAgendamentoRequest;
import com.vetpulse.ports.inbound.CancelarAgendamentoUseCase;
import com.vetpulse.ports.inbound.ConfirmarAgendamentoUseCase;
import com.vetpulse.ports.inbound.CriarAgendamentoUseCase;
import com.vetpulse.ports.inbound.RealizarAgendamentoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private static final Logger log = LoggerFactory.getLogger(AgendamentoController.class);

    private final CriarAgendamentoUseCase criarAgendamentoUseCase;
    private final ConfirmarAgendamentoUseCase confirmarAgendamentoUseCase;
    private final CancelarAgendamentoUseCase cancelarAgendamentoUseCase;
    private final RealizarAgendamentoUseCase realizarAgendamentoUseCase;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criar(@Valid @RequestBody CriarAgendamentoRequest request) {
        log.debug("Requisição recebida: POST /api/v1/agendamentos, payload: {}", request);
        var agendamento = criarAgendamentoUseCase.criar(
                request.petId(),
                request.tutorId(),
                request.veterinarioId(),
                request.horario()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AgendamentoResponse.from(agendamento));
    }

    @PatchMapping("/{id}/confirmar")
    public ResponseEntity<AgendamentoResponse> confirmar(@PathVariable UUID id) {
        log.debug("Requisição recebida: PATCH /api/v1/agendamentos/{}/confirmar", id);
        var agendamento = confirmarAgendamentoUseCase.confirmar(id);
        return ResponseEntity.ok(AgendamentoResponse.from(agendamento));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<AgendamentoResponse> cancelar(@PathVariable UUID id) {
        log.debug("Requisição recebida: PATCH /api/v1/agendamentos/{}/cancelar", id);
        var agendamento = cancelarAgendamentoUseCase.cancelar(id);
        return ResponseEntity.ok(AgendamentoResponse.from(agendamento));
    }

    @PatchMapping("/{id}/realizar")
    public ResponseEntity<AgendamentoResponse> realizar(@PathVariable UUID id) {
        log.debug("Requisição recebida: PATCH /api/v1/agendamentos/{}/realizar", id);
        var agendamento = realizarAgendamentoUseCase.realizar(id);
        return ResponseEntity.ok(AgendamentoResponse.from(agendamento));
    }
}

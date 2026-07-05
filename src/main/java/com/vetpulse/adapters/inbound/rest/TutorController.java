package com.vetpulse.adapters.inbound.rest;

import com.vetpulse.adapters.inbound.dto.tutor.CriarTutorRequest;
import com.vetpulse.adapters.inbound.dto.tutor.TutorResponse;
import com.vetpulse.ports.inbound.CriarTutorUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final CriarTutorUseCase criarTutorUseCase;

    @PostMapping
    public ResponseEntity<TutorResponse> criar(@Valid @RequestBody CriarTutorRequest request) {
        var tutor = criarTutorUseCase.criar(
                request.nome(),
                request.email(),
                request.senha(),
                request.telefone()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TutorResponse.from(tutor));
    }

}

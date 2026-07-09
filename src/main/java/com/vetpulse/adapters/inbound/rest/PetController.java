package com.vetpulse.adapters.inbound.rest;

import com.vetpulse.adapters.inbound.dto.pet.CriarPetRequest;
import com.vetpulse.adapters.inbound.dto.pet.PetResponse;
import com.vetpulse.ports.inbound.CriarPetUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private final CriarPetUseCase criarPetUseCase;
    private final Clock clock;

    @PostMapping
    public ResponseEntity<PetResponse> criar(@Valid @RequestBody CriarPetRequest request) {
        var pet = criarPetUseCase.criar(
                request.nome(),
                request.especie(),
                request.dataNascimento(),
                request.tutorId()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PetResponse.from(pet, clock));
    }
}

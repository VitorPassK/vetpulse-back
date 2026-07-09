package com.vetpulse.adapters.inbound.rest;

import com.vetpulse.adapters.inbound.dto.veterinario.CriarVeterinarioRequest;
import com.vetpulse.adapters.inbound.dto.veterinario.VeterinarioResponse;
import com.vetpulse.ports.inbound.CriarVeterinarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final CriarVeterinarioUseCase criarVeterinarioUseCase;

    @PostMapping
    public ResponseEntity<VeterinarioResponse> criar(@Valid @RequestBody CriarVeterinarioRequest request) {
        var veterinario = criarVeterinarioUseCase.criar(
                request.nome(),
                request.email(),
                request.senha(),
                request.crmv()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(VeterinarioResponse.from(veterinario));
    }

}

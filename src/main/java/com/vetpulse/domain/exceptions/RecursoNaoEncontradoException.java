package com.vetpulse.domain.exceptions;

import java.util.UUID;

public class RecursoNaoEncontradoException extends DomainException {

    public RecursoNaoEncontradoException(String recurso, UUID id) {
        super("%s não encontrado(a) com id: %s".formatted(recurso, id));
    }
}

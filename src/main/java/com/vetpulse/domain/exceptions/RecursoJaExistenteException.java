package com.vetpulse.domain.exceptions;

public class RecursoJaExistenteException extends DomainException {

    public RecursoJaExistenteException(String recurso, String campo, String valor) {
        super("%s já cadastrado(a) com %s: %s".formatted(recurso, campo, valor));
    }
}

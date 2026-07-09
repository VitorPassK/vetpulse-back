package com.vetpulse.domain.exceptions;

import java.time.LocalDateTime;
import java.util.UUID;

public class AgendamentoConflitanteException extends DomainException {

    public AgendamentoConflitanteException(UUID veterinarioId, LocalDateTime horario) {
        super("Veterinário %s já possui agendamento no horário: %s".formatted(veterinarioId, horario));
    }
}

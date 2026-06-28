package com.vetpulse.domain.models;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Objects;

public class Agendamento {
    private final String id;
    private final String petId;
    private final String tutorId;
    private final String veterinarioId;
    private final LocalDateTime horario;
    private StatusAgendamento status;

    public Agendamento(String id, String petId, String tutorId, String veterinarioId, LocalDateTime horario, Clock clock) {
        if (horario == null) {
            throw new IllegalArgumentException("Horário é obrigatório");
        }
        if (horario.isBefore(LocalDateTime.now(clock))) {
            throw new IllegalArgumentException("Não é possível agendar em um horário no passado");
        }
        this.id = id;
        this.petId = petId;
        this.tutorId = tutorId;
        this.veterinarioId = veterinarioId;
        this.horario = horario;
        this.status = StatusAgendamento.PENDENTE;
    }

    public void confirmar() {
        if (status != StatusAgendamento.PENDENTE) {
            throw new IllegalStateException("Só é possível confirmar um agendamento PENDENTE. Status atual: " + status);
        }
        this.status = StatusAgendamento.CONFIRMADO;
    }

    public void realizar() {
        if (status != StatusAgendamento.CONFIRMADO) {
            throw new IllegalStateException("Só é possível realizar um agendamento CONFIRMADO. Status atual: " + status);
        }
        this.status = StatusAgendamento.REALIZADO;
    }

    public void cancelar() {
        if (status == StatusAgendamento.REALIZADO || status == StatusAgendamento.CANCELADO) {
            throw new IllegalStateException("Não é possível cancelar um agendamento com status " + status);
        }
        this.status = StatusAgendamento.CANCELADO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agendamento that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

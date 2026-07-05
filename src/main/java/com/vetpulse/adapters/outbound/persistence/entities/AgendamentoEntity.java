package com.vetpulse.adapters.outbound.persistence.entities;

import com.vetpulse.domain.models.StatusAgendamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "agendamentos",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_veterinario_horario",
                        columnNames = {"veterinario_id", "horario"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class AgendamentoEntity {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "pet_id", nullable = false, columnDefinition = "uuid")
    private UUID petId;

    @Column(name = "tutor_id", nullable = false, columnDefinition = "uuid")
    private UUID tutorId;

    @Column(name = "veterinario_id", nullable = false, columnDefinition = "uuid")
    private UUID veterinarioId;

    @Column(nullable = false)
    private LocalDateTime horario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    @Version
    @Column(nullable = false)
    private Long versao;

    public AgendamentoEntity(
            UUID id, UUID petId, UUID tutorId, UUID veterinarioId, LocalDateTime horario, StatusAgendamento status
    ) {
        this.id = id;
        this.petId = petId;
        this.tutorId = tutorId;
        this.veterinarioId = veterinarioId;
        this.horario = horario;
        this.status = status;
    }
}

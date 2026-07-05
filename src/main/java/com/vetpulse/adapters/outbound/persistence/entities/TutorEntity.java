package com.vetpulse.adapters.outbound.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tutores")
@DiscriminatorValue("TUTOR")
@Getter
@Setter
@NoArgsConstructor
public class TutorEntity extends UsuarioEntity {

    @Column(nullable = false)
    private String telefone;

    public TutorEntity(UUID id, String nome, String email, String senhaHash, String telefone) {
        super(id, nome, email, senhaHash);
        this.telefone = telefone;
    }
}

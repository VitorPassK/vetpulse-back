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
@Table(name = "veterinarios")
@DiscriminatorValue("VETERINARIO")
@Getter
@Setter
@NoArgsConstructor
public class VeterinarioEntity extends UsuarioEntity {

    @Column(nullable = false, unique = true)
    private String crmv;

    public VeterinarioEntity(UUID id, String nome, String email, String senhaHash, String crmv) {
        super(id, nome, email, senhaHash);
        this.crmv = crmv;
    }
}

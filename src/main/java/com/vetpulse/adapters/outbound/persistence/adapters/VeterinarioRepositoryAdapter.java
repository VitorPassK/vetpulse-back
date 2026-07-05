package com.vetpulse.adapters.outbound.persistence.adapters;

import com.vetpulse.adapters.outbound.persistence.entities.VeterinarioEntity;
import com.vetpulse.adapters.outbound.persistence.repositories.VeterinarioJpaRepository;
import com.vetpulse.domain.models.Veterinario;
import com.vetpulse.ports.outbound.VeterinarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class VeterinarioRepositoryAdapter implements VeterinarioRepositoryPort {

    private final VeterinarioJpaRepository jpaRepository;

    @Override
    public Optional<Veterinario> buscarPorId(UUID id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Optional<Veterinario> buscarPorEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public Optional<Veterinario> buscarPorCrmv(String crmv) {
        return jpaRepository.findByCrmv(crmv)
                .map(this::toDomain);
    }

    @Override
    public Veterinario salvar(Veterinario veterinario) {
        VeterinarioEntity entity = toEntity(veterinario);
        VeterinarioEntity salvo = jpaRepository.save(entity);
        return toDomain(salvo);
    }

    private Veterinario toDomain(VeterinarioEntity entity) {
        return new Veterinario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getSenhaHash(),
                entity.getCrmv()
        );
    }

    private VeterinarioEntity toEntity(Veterinario veterinario) {
        return new VeterinarioEntity(
                veterinario.getId(),
                veterinario.getNome(),
                veterinario.getEmail(),
                veterinario.getSenhaHash(),
                veterinario.getCrmv()
        );
    }

}

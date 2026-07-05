package com.vetpulse.adapters.outbound.persistence.adapters;

import com.vetpulse.adapters.outbound.persistence.entities.TutorEntity;
import com.vetpulse.adapters.outbound.persistence.repositories.TutorJpaRepository;
import com.vetpulse.domain.models.Tutor;
import com.vetpulse.ports.outbound.TutorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TutorRepositoryAdapter implements TutorRepositoryPort {

    private final TutorJpaRepository jpaRepository;

    @Override
    public Optional<Tutor> buscarPorId(UUID id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Optional<Tutor> buscarPorEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public Tutor salvar(Tutor tutor) {
        TutorEntity entity = toEntity(tutor);
        TutorEntity salvo = jpaRepository.save(entity);
        return toDomain(salvo);
    }

    private Tutor toDomain(TutorEntity entity) {
        return new Tutor(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getSenhaHash(),
                entity.getTelefone()
        );
    }

    private TutorEntity toEntity(Tutor tutor) {
        return new TutorEntity(
                tutor.getId(),
                tutor.getNome(),
                tutor.getEmail(),
                tutor.getSenhaHash(),
                tutor.getTelefone()
        );
    }

}

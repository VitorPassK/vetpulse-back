package com.vetpulse.adapters.inbound.config;

import com.vetpulse.adapters.outbound.persistence.adapters.AgendamentoRepositoryAdapter;
import com.vetpulse.adapters.outbound.persistence.adapters.PetRepositoryAdapter;
import com.vetpulse.adapters.outbound.persistence.adapters.TutorRepositoryAdapter;
import com.vetpulse.adapters.outbound.persistence.adapters.VeterinarioRepositoryAdapter;
import com.vetpulse.adapters.outbound.security.PasswordHasherAdapter;
import com.vetpulse.domain.services.*;
import com.vetpulse.ports.inbound.*;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

public class BeansConfig {

    @Bean
    public CriarTutorUseCase criarTutorUseCase(
            TutorRepositoryAdapter tutorRepository,
            PasswordHasherAdapter passwordHasher) {
        return new CriarTutorService(tutorRepository, passwordHasher);
    }

    @Bean
    public CriarVeterinarioUseCase criarVeterinarioUseCase(VeterinarioRepositoryAdapter veterinarioRepository,
                                                           PasswordHasherAdapter passwordHasher) {
        return new CriarVeterinarioService(veterinarioRepository, passwordHasher);
    }

    @Bean
    public CriarPetUseCase criarPetUseCase(PetRepositoryAdapter petRepository,
                                           TutorRepositoryAdapter tutorRepository,
                                           Clock clock) {
        return new CriarPetService(petRepository, tutorRepository, clock);
    }

    @Bean
    public CriarAgendamentoUseCase criarAgendamentoUseCase(AgendamentoRepositoryAdapter agendamentoRepository,
                                                           PetRepositoryAdapter petRepository,
                                                           VeterinarioRepositoryAdapter vetRepository,
                                                           Clock clock) {
        return new CriarAgendamentoService(agendamentoRepository, petRepository, vetRepository, clock);
    }

    @Bean
    public ConfirmarAgendamentoUseCase confirmarAgendamentoUseCase(AgendamentoRepositoryAdapter agendamentoRepository) {
        return new ConfirmarAgendamentoService(agendamentoRepository);
    }

    @Bean
    public CancelarAgendamentoUseCase cancelarAgendamentoUseCase(AgendamentoRepositoryAdapter agendamentoRepository) {
        return new CancelarAgendamentoService(agendamentoRepository);
    }

    @Bean
    public RealizarAgendamentoUseCase realizarAgendamentoUseCase(AgendamentoRepositoryAdapter agendamentoRepository) {
        return new RealizarAgendamentoService(agendamentoRepository);
    }
}

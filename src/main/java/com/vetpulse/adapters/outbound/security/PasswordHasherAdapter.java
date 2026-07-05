package com.vetpulse.adapters.outbound.security;

import com.vetpulse.ports.outbound.PasswordHasherPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordHasherAdapter implements PasswordHasherPort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String hash(String senhaEmTextoPuro) {
        return passwordEncoder.encode(senhaEmTextoPuro);
    }

    @Override
    public boolean verificar(String senhaEmTextoPuro, String hashArmazenado) {
        return passwordEncoder.matches(senhaEmTextoPuro, hashArmazenado);
    }
}

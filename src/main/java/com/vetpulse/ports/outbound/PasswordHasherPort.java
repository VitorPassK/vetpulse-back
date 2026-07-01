package com.vetpulse.ports.outbound;

public interface PasswordHasherPort {

    String hash(String senhaEmTextoPuro);

    boolean verificar(String senhaEmTextoPuro, String hashArmazenado);

}

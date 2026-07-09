CREATE TABLE agendamentos (
    id UUID NOT NULL,
    pet_id UUID NOT NULL,
    tutor_id UUID NOT NULL,
    veterinario_id UUID NOT NULL,
    horario TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    versao BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT pk_agendamentos PRIMARY KEY (id),
    CONSTRAINT uk_veterinario_horario UNIQUE (veterinario_id, horario),
    CONSTRAINT fk_agendamentos_pet FOREIGN KEY (pet_id)
        REFERENCES pets (id),
    CONSTRAINT fk_agendamentos_tutor FOREIGN KEY (tutor_id)
        REFERENCES usuarios (id),
    CONSTRAINT fk_agendamentos_veterinario FOREIGN KEY (veterinario_id)
        REFERENCES usuarios (id)
);

CREATE INDEX idx_agendamentos_veterinario_horario
    ON agendamentos (veterinario_id, horario);

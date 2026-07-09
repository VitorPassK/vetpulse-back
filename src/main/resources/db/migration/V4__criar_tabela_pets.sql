CREATE TABLE pets (
    id UUID NOT NULL,
    nome VARCHAR(255) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    data_nascimento DATE,
    tutor_id UUID NOT NULL,

    CONSTRAINT pk_pets PRIMARY KEY (id),
    CONSTRAINT fk_pets_tutor FOREIGN KEY (tutor_id)
        REFERENCES usuarios (id)
        ON DELETE CASCADE
);

CREATE TABLE tutores (
    id UUID NOT NULL,
    telefone VARCHAR(20) NOT NULL,

    CONSTRAINT pk_tutores PRIMARY KEY (id),
    CONSTRAINT fk_tutores_usuarios FOREIGN KEY (id)
        REFERENCES usuarios (id)
        ON DELETE CASCADE
);

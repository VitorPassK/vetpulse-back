CREATE TABLE veterinarios (
    id UUID NOT NULL,
    crmv VARCHAR(20) NOT NULL,

    CONSTRAINT pk_veterinarios PRIMARY KEY (id),
    CONSTRAINT uk_veterinarios_crmv UNIQUE (crmv),
    CONSTRAINT fk_veterinarios_usuarios FOREIGN KEY (id)
        REFERENCES usuarios (id)
        ON DELETE CASCADE
);

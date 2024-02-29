CREATE TABLE IF NOT EXISTS client(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (length(name) >= 3 AND length(name) <= 200)
);

CREATE TABLE IF NOT EXISTS planet(
    id VARCHAR(200) PRIMARY KEY NOT NULL CHECK (length(name) >= 1 AND length(name) <= 200)
        CONSTRAINT id_format_check CHECK (id ~ '^[A-Z0-9]+$'),
    name VARCHAR(500) NOT NULL CHECK (length(name) >= 1 AND length(name) <= 500)
);

CREATE TABLE IF NOT EXISTS ticket(
    id BIGSERIAL PRIMARY KEY,
    create_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    client_id BIGINT REFERENCES client(id),
    from_planet VARCHAR(200) REFERENCES planet(id),
    to_planet VARCHAR(200) REFERENCES planet(id)
);
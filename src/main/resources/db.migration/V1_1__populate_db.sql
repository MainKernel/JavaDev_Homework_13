INSERT INTO client (name)
values
    ('Sophia Johnson'),
    ('Liam Smith'),
    ('Olivia Brown'),
    ('Noah Williams'),
    ('Emma Jones'),
    ('Jackson Davis'),
    ('Ava Miller'),
    ('Lucas Wilson'),
    ('Isabella Taylor'),
    ('Aiden Anderson');

INSERT INTO planet(id, name)
VALUES
('NPTS','Neptis'),
('TRNV','Terranova'),
('SOLRA','Solaria'),
('NVRIA','Novaria'),
('ATHRIA','Aetheria');

INSERT INTO ticket(client_id, from_planet, to_planet)
VALUES
    (1, 'NPTS', 'TRNV'),
    (2, 'SOLRA', 'NVRIA'),
    (3, 'ATHRIA', 'NPTS'),
    (4, 'TRNV', 'SOLRA'),
    (5, 'NVRIA', 'ATHRIA'),
    (6, 'NPTS', 'SOLRA'),
    (7, 'SOLRA', 'NPTS'),
    (8, 'TRNV', 'NPTS'),
    (9, 'NVRIA', 'ATHRIA'),
    (10, 'SOLRA', 'NVRIA');
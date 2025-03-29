CREATE TABLE IF NOT EXISTS lennud (
                                      id SERIAL PRIMARY KEY,
                                      sihtkoht VARCHAR(255) NOT NULL,
    hind DOUBLE PRECISION NOT NULL,
    lennuaeg TIME NOT NULL,
    kuupäev DATE NOT NULL
    );

CREATE TABLE IF NOT EXISTS istekohad (
                                         id SERIAL PRIMARY KEY,
                                         istme_number VARCHAR(10) NOT NULL,
    on_vaba BOOLEAN NOT NULL,
    on_aknaall BOOLEAN NOT NULL,
    on_jalaruum BOOLEAN NOT NULL,
    on_valjapaas BOOLEAN NOT NULL,
    lennud_id INTEGER NOT NULL,
    FOREIGN KEY (lennud_id) REFERENCES lennud(id) ON DELETE CASCADE
    );
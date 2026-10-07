CREATE TABLE venues (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(200) NOT NULL
);

CREATE TABLE seats (
    id          BIGSERIAL PRIMARY KEY,
    venue_id    BIGINT NOT NULL REFERENCES venues(id),
    row         VARCHAR(10) NOT NULL,
    seat_number INT NOT NULL,
    UNIQUE (venue_id, row, seat_number)
);
ALTER TABLE events ADD COLUMN venue_id BIGINT REFERENCES venues(id);
UPDATE events SET venue_id = 1;                                        
ALTER TABLE events ALTER COLUMN venue_id SET NOT NULL;                 
CREATE TABLE event_seats (                                            
    id          BIGSERIAL PRIMARY KEY,
    event_id    BIGINT NOT NULL REFERENCES events(id),
    seat_id     BIGINT NOT NULL REFERENCES seats(id),
    status      VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE',
    UNIQUE (event_id, seat_id)
);
INSERT INTO event_seats (event_id, seat_id)
SELECT e.id, s.id
FROM events e
JOIN seats s ON s.venue_id = e.venue_id;
    
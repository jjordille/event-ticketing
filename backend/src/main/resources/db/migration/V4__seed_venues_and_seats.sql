INSERT INTO venues (name) VALUES ('Main Hall');

INSERT INTO seats (venue_id, row, seat_number)
SELECT 1, chr(64 + r), s
FROM generate_series(1, 10) AS r, generate_series(1, 12) AS s;
import { useSeats, type Seat } from "../api/seats";

export function SeatMap({ venueId }: { venueId: number }) {
  const { data: seats, isPending, isError, error } = useSeats(venueId);

  if (isPending) return <p>Loading seat map…</p>;
  if (isError)
    return (
      <p className="status-error">Could not load seat map: {error.message}</p>
    );
  if (!seats || seats.length === 0) return <p>No seats available.</p>;

  const rows: Record<string, Seat[]> = {};
  for (const seat of seats) {
    (rows[seat.rowLabel] ??= []).push(seat);
  }

  return (
    <ul className="seat-map">
      {Object.entries(rows).map(([rowLabel, rowSeats]) => (
        <li key={rowLabel} className="seat-row">
          <span className="seat-row-label">{rowLabel}</span>
          {rowSeats.map((seat) => (
            <button key={seat.id}>{seat.seatNumber}</button>
          ))}
        </li>
      ))}
    </ul>
  );
}

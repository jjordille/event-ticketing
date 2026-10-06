import { useEvents } from '../api/events'

const dateFormat = new Intl.DateTimeFormat(undefined, { dateStyle: 'medium', timeStyle: 'short' })

export function EventList() {
  const { data: events, isPending, isError, error } = useEvents()

  if (isPending) return <p>Loading events…</p>
  if (isError) return <p className="status-error">Could not load events: {error.message}</p>
  if (events.length === 0) return <p>No upcoming events.</p>

  return (
    <ul className="event-list">
      {events.map((event) => (
        <li key={event.id} className="event-card">
          <h2>{event.name}</h2>
          <p className="event-meta">
            {event.venue} · {dateFormat.format(new Date(event.startsAt))}
          </p>
          {event.description && <p>{event.description}</p>}
        </li>
      ))}
    </ul>
  )
}

import { BackendStatus } from './components/BackendStatus'
import { EventList } from './components/EventList'
import { SeatMap } from './components/SeatMap'

function App() {
  return (
    <main className="container">
      <header>
        <h1>Event Ticketing</h1>
        <BackendStatus />
      </header>
      <EventList />
      <SeatMap venueId={1} />
    </main>
  )
}

export default App

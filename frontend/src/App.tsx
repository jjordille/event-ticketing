import { BackendStatus } from './components/BackendStatus'
import { EventList } from './components/EventList'

function App() {
  return (
    <main className="container">
      <header>
        <h1>Event Ticketing</h1>
        <BackendStatus />
      </header>
      <EventList />
    </main>
  )
}

export default App

import { usePing } from '../api/events'

export function BackendStatus() {
  const { data, isPending, isError } = usePing()

  if (isPending) return <p className="status">Checking backend…</p>
  if (isError) return <p className="status status-error">Backend unreachable. Is Spring Boot running on :8080?</p>

  return (
    <p className="status status-ok">
      Backend says <strong>{data.message}</strong> at {new Date(data.timestamp).toLocaleTimeString()}
    </p>
  )
}

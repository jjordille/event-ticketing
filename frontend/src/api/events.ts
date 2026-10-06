import { useQuery } from '@tanstack/react-query'
import { apiGet } from './client'

// Mirrors EventResponse.java on the backend.
export interface Event {
  id: number
  name: string
  venue: string
  startsAt: string
  description: string | null
}

export interface PingResponse {
  message: string
  timestamp: string
}

export function usePing() {
  return useQuery({ queryKey: ['ping'], queryFn: () => apiGet<PingResponse>('/ping') })
}

export function useEvents() {
  return useQuery({ queryKey: ['events'], queryFn: () => apiGet<Event[]>('/events') })
}

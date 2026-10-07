import { useQuery } from '@tanstack/react-query'
import { apiGet } from './client'

export interface Seat {
    id: number
    rowLabel: string
    seatNumber: number
}

export function useSeats(venueId: number) {
    return useQuery({ queryKey: ['seats', venueId], queryFn: () => apiGet<Seat[]>(`/venues/${venueId}/seats`) })
}

export interface EventSeat {
    id: number
    rowLabel: string
    seatNumber: number
    status: 'AVAILABLE' | 'RESERVED' | 'SOLD'
}

export function useEventSeats(eventId: number) {
    return useQuery({ queryKey: ['eventSeats', eventId], queryFn: () => apiGet<EventSeat[]>(`/events/${eventId}/seats`) })
}
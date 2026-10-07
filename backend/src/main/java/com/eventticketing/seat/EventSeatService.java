package com.eventticketing.seat;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EventSeatService {
    private EventSeatRepository eventSeatRepository;

    public EventSeatService(EventSeatRepository eventSeatRepository) {
        this.eventSeatRepository = eventSeatRepository;
    }

    public List<EventSeatResponse> findByEventId(Long eventId) {
        return eventSeatRepository.findByEventIdWithSeat(eventId).stream()
                .map(eventSeat -> new EventSeatResponse(
                        eventSeat.getId(),
                        eventSeat.getSeat().getRowLabel(),
                        eventSeat.getSeat().getSeatNumber(),
                        eventSeat.getStatus()))
                .toList();
    }

    @Transactional
    public void reserveSeat(Long eventId, Long eventSeatId) {
        int updated = eventSeatRepository.reserve(eventId, eventSeatId, OffsetDateTime.now().plusMinutes(10));
        if (updated == 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Seat is not available");
        }
    }
}

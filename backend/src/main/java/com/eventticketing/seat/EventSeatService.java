package com.eventticketing.seat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}

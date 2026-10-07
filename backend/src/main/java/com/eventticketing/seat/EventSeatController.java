package com.eventticketing.seat;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventSeatController {
    private EventSeatService eventSeatService;

    public EventSeatController(EventSeatService eventSeatService) {
        this.eventSeatService = eventSeatService;
    }

    @GetMapping("/{eventId}/seats")
    public List<EventSeatResponse> getEventSeats(@PathVariable Long eventId) {
        return eventSeatService.findByEventId(eventId);
    }

    @PostMapping("/{eventId}/seats/{seatId}/reserve")
    public void reserveSeat(@PathVariable Long eventId, @PathVariable Long seatId) {
        eventSeatService.reserveSeat(eventId, seatId);
    }
}

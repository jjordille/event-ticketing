package com.eventticketing.event;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Business logic layer. Controllers stay thin and delegate here; this is
 * where seat-hold and booking rules will live later.
 */
@Service
@Transactional(readOnly = true)
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> findAll() {
        return eventRepository.findAllByOrderByStartsAtAsc().stream()
                .map(EventResponse::from)
                .toList();
    }

    public EventResponse findById(Long id) {
        return eventRepository.findById(id)
                .map(EventResponse::from)
                .orElseThrow(() -> new EventNotFoundException(id));
    }
}

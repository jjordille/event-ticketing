package com.eventticketing.event;

import java.time.OffsetDateTime;

/**
 * The JSON shape returned to the frontend. Keeping this separate from the
 * entity means database changes don't leak into the API contract.
 */
public record EventResponse(Long id, String name, String venue, OffsetDateTime startsAt, String description) {

    static EventResponse from(Event event) {
        return new EventResponse(event.getId(), event.getName(), event.getVenue(),
                event.getStartsAt(), event.getDescription());
    }
}

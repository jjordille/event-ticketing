package com.eventticketing.event;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * JPA entity mapped to the "events" table (created by Flyway migration V1).
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String venue;

    @Column(name = "starts_at", nullable = false)
    private OffsetDateTime startsAt;

    private String description;

    protected Event() {
        // required by JPA
    }

    public Event(String name, String venue, OffsetDateTime startsAt, String description) {
        this.name = name;
        this.venue = venue;
        this.startsAt = startsAt;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

    public OffsetDateTime getStartsAt() {
        return startsAt;
    }

    public String getDescription() {
        return description;
    }
}

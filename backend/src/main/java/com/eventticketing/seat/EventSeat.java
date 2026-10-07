package com.eventticketing.seat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_seats")
public class EventSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(name = "status", nullable = false)
    private String status;

    protected EventSeat() {
        // required by JPA
    }

    public EventSeat(Long eventId, Seat seat, String status) {
        this.eventId = eventId;
        this.seat = seat;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getEventId() {
        return eventId;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getStatus() {
        return status;
    }
}

package com.eventticketing.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import java.time.OffsetDateTime;
import java.util.List;

public interface EventSeatRepository extends JpaRepository<EventSeat, Long> {

    @Query("""
            select es from EventSeat es
            join fetch es.seat s
            where es.eventId = :eventId
            order by s.rowLabel, s.seatNumber
            """)
    List<EventSeat> findByEventIdWithSeat(@Param("eventId") Long eventId);

    @Modifying
    @Query("""
            update EventSeat es
            set es.status = 'RESERVED', es.holdExpiresAt = :expiresAt
            where es.id = :eventSeatId
              and es.eventId = :eventId
              and es.status = 'AVAILABLE'
            """)
    int reserve(@Param("eventId") Long eventId, @Param("eventSeatId") Long eventSeatId, @Param("expiresAt") OffsetDateTime expiresAt);
}

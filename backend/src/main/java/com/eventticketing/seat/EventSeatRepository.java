package com.eventticketing.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventSeatRepository extends JpaRepository<EventSeat, Long> {

    @Query("""
            select es from EventSeat es
            join fetch es.seat s
            where es.eventId = :eventId
            order by s.rowLabel, s.seatNumber
            """)
    List<EventSeat> findByEventIdWithSeat(@Param("eventId") Long eventId);
}

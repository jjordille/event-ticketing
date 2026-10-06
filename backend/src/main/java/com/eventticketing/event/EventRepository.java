package com.eventticketing.event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data generates the implementation of this interface at runtime.
 */
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByOrderByStartsAtAsc();
}

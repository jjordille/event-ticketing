package com.eventticketing.seat;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SeatService {
    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<SeatResponse> findByVenueId(Long venueId) {
        return seatRepository.findByVenueIdOrderByRowLabelAscSeatNumberAsc(venueId).stream()
                .map(seat -> new SeatResponse(seat.getId(), seat.getRowLabel(), seat.getSeatNumber()))
                .toList();
    }
}

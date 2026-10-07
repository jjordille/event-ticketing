package com.eventticketing.seat;

public class SeatResponse {
    private Long id;
    private String rowLabel;
    private Integer seatNumber;

    public SeatResponse(Long id, String rowLabel, Integer seatNumber) {
        this.id = id;
        this.rowLabel = rowLabel;
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public String getRowLabel() {
        return rowLabel;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }
}

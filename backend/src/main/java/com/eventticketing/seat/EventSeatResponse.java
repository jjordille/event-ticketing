package com.eventticketing.seat;

public class EventSeatResponse {
    private Long id;
    private String rowLabel;
    private Integer seatNumber;
    private String status;

    public EventSeatResponse(Long id, String rowLabel, Integer seatNumber, String status) {
        this.id = id;
        this.rowLabel = rowLabel;
        this.seatNumber = seatNumber;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}

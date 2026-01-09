package com.ams.passengerService.staff.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShiftCreateRequest {
    private Long staffId;
    private LocalDate day;
    private LocalTime timeFrom;
    private LocalTime timeTo;

    public Long getStaffId() { return staffId; }
    public LocalDate getDay() { return day; }
    public LocalTime getTimeFrom() { return timeFrom; }
    public LocalTime getTimeTo() { return timeTo; }

    public void setStaffId(Long staffId) { this.staffId = staffId; }
    public void setDay(LocalDate day) { this.day = day; }
    public void setTimeFrom(LocalTime timeFrom) { this.timeFrom = timeFrom; }
    public void setTimeTo(LocalTime timeTo) { this.timeTo = timeTo; }
}


package com.ams.passengerService.staff.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shifts")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long staffId;

    private LocalDate day;
    private LocalTime timeFrom;
    private LocalTime timeTo;

    public Shift() {}

    public Shift(Long staffId, LocalDate day, LocalTime timeFrom, LocalTime timeTo) {
        this.staffId = staffId;
        this.day = day;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public Long getId() { return id; }
    public Long getStaffId() { return staffId; }
    public LocalDate getDay() { return day; }
    public LocalTime getTimeFrom() { return timeFrom; }
    public LocalTime getTimeTo() { return timeTo; }

    public void setStaffId(Long staffId) { this.staffId = staffId; }
    public void setDay(LocalDate day) { this.day = day; }
    public void setTimeFrom(LocalTime timeFrom) { this.timeFrom = timeFrom; }
    public void setTimeTo(LocalTime timeTo) { this.timeTo = timeTo; }
}

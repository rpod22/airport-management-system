package com.ams.passengerService.report.dto;

public class KpiResponse {
    private long flights;
    private long gates;
    private long passengers;
    private long staff;
    private long shifts;

    public KpiResponse() {}

    public KpiResponse(long flights, long gates, long passengers, long staff, long shifts) {
        this.flights = flights;
        this.gates = gates;
        this.passengers = passengers;
        this.staff = staff;
        this.shifts = shifts;
    }

    public long getFlights() { return flights; }
    public long getGates() { return gates; }
    public long getPassengers() { return passengers; }
    public long getStaff() { return staff; }
    public long getShifts() { return shifts; }

    public void setFlights(long flights) { this.flights = flights; }
    public void setGates(long gates) { this.gates = gates; }
    public void setPassengers(long passengers) { this.passengers = passengers; }
    public void setStaff(long staff) { this.staff = staff; }
    public void setShifts(long shifts) { this.shifts = shifts; }
}

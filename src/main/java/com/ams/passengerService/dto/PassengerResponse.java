package com.ams.passengerService.dto;

import com.ams.passengerService.model.Passenger;

public class PassengerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String flightNumber;
    private boolean checkedIn;

    public PassengerResponse() {}

    public PassengerResponse(Long id, String firstName, String lastName, String passportNumber, String flightNumber, boolean checkedIn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.flightNumber = flightNumber;
        this.checkedIn = checkedIn;
    }

    public static PassengerResponse from(Passenger p) {
        return new PassengerResponse(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getPassportNumber(),
                p.getFlightNumber(),
                p.isCheckedIn()
        );
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPassportNumber() { return passportNumber; }
    public String getFlightNumber() { return flightNumber; }
    public boolean isCheckedIn() { return checkedIn; }
}

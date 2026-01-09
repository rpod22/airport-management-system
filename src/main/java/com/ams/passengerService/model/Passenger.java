package com.ams.passengerService.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "passengers",
        uniqueConstraints = @UniqueConstraint(name = "uk_passport_number", columnNames = "passport_number")
)
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="passport_number", nullable = false)
    private String passportNumber;

    @Column(name="flight_number")
    private String flightNumber;

    @Column(name="checked_in", nullable = false)
    private boolean checkedIn = false;

    public Passenger() {}

    public Passenger(String firstName, String lastName, String passportNumber, String flightNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.flightNumber = flightNumber;
        this.checkedIn = false;
    }

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public boolean isCheckedIn() { return checkedIn; }
    public void setCheckedIn(boolean checkedIn) { this.checkedIn = checkedIn; }
}

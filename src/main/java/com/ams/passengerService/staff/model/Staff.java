package com.ams.passengerService.staff.model;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private StaffRole role;

    private boolean active = true;

    public Staff() {}

    public Staff(String firstName, String lastName, StaffRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.active = true;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public StaffRole getRole() { return role; }
    public boolean isActive() { return active; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setRole(StaffRole role) { this.role = role; }
    public void setActive(boolean active) { this.active = active; }
}

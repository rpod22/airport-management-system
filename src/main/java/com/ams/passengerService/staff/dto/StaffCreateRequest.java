package com.ams.passengerService.staff.dto;

import com.ams.passengerService.staff.model.StaffRole;

public class StaffCreateRequest {
    private String firstName;
    private String lastName;
    private StaffRole role;

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public StaffRole getRole() { return role; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setRole(StaffRole role) { this.role = role; }
}


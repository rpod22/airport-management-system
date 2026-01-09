package com.ams.passengerService.staff.repository;

import com.ams.passengerService.staff.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}

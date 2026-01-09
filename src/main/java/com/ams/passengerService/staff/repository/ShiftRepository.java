package com.ams.passengerService.staff.repository;

import com.ams.passengerService.staff.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findByStaffId(Long staffId);
    List<Shift> findByDay(LocalDate day);
}

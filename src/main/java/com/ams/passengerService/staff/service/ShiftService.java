package com.ams.passengerService.staff.service;

import com.ams.passengerService.exception.ConflictException;
import com.ams.passengerService.exception.NotFoundException;
import com.ams.passengerService.staff.dto.ShiftCreateRequest;
import com.ams.passengerService.staff.model.Shift;
import com.ams.passengerService.staff.repository.ShiftRepository;
import com.ams.passengerService.staff.repository.StaffRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;
    private final StaffRepository staffRepository;

    public ShiftService(ShiftRepository shiftRepository, StaffRepository staffRepository) {
        this.shiftRepository = shiftRepository;
        this.staffRepository = staffRepository;
    }

    @Transactional
    public Shift create(ShiftCreateRequest req) {
        if (req.getTimeFrom() != null && req.getTimeTo() != null && req.getTimeFrom().isAfter(req.getTimeTo())) {
            throw new ConflictException("timeFrom must be before timeTo");
        }

        if (!staffRepository.existsById(req.getStaffId())) {
            throw new NotFoundException("Staff not found: " + req.getStaffId());
        }

        Shift s = new Shift(req.getStaffId(), req.getDay(), req.getTimeFrom(), req.getTimeTo());
        return shiftRepository.save(s);
    }

    public List<Shift> all() {
        return shiftRepository.findAll();
    }

    public List<Shift> byStaff(Long staffId) {
        return shiftRepository.findByStaffId(staffId);
    }
}

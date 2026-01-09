package com.ams.passengerService.staff.service;

import com.ams.passengerService.exception.NotFoundException;
import com.ams.passengerService.staff.dto.StaffCreateRequest;
import com.ams.passengerService.staff.model.Staff;
import com.ams.passengerService.staff.repository.StaffRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Transactional
    public Staff create(StaffCreateRequest req) {
        Staff s = new Staff(req.getFirstName(), req.getLastName(), req.getRole());
        return staffRepository.save(s);
    }

    public List<Staff> all() {
        return staffRepository.findAll();
    }

    public Staff get(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Staff not found: " + id));
    }

    @Transactional
    public Staff deactivate(Long id) {
        Staff s = get(id);
        s.setActive(false);
        return staffRepository.save(s);
    }
}

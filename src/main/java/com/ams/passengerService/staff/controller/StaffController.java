package com.ams.passengerService.staff.controller;

import com.ams.passengerService.staff.dto.StaffCreateRequest;
import com.ams.passengerService.staff.model.Staff;
import com.ams.passengerService.staff.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @PostMapping
    public Staff create(@RequestBody StaffCreateRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<Staff> all() {
        return service.all();
    }

    @PatchMapping("/{id}/deactivate")
    public Staff deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}

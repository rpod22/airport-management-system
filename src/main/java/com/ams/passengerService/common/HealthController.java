package com.ams.passengerService.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Airport Management API is running. Try /api/passengers, /api/flights, /api/gates";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}

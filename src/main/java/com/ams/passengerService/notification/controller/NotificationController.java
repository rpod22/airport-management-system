package com.ams.passengerService.notification.controller;

import com.ams.passengerService.notification.model.Notification;
import com.ams.passengerService.notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification send(@RequestBody Notification notification) {
        return service.send(notification);
    }

    @GetMapping
    public List<Notification> all() {
        return service.getAll();
    }
}

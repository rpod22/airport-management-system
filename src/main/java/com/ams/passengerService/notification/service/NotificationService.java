package com.ams.passengerService.notification.service;

import com.ams.passengerService.notification.model.Notification;
import com.ams.passengerService.notification.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification send(Notification notification) {
        Notification saved = repository.save(notification);
        log.info("NOTIFICATION SENT: id={}, type={}, recipient={}, message={}",
                saved.getId(), saved.getType(), saved.getRecipient(), saved.getMessage());
        return saved;
    }

    public List<Notification> getAll() {
        return repository.findAll();
    }
}

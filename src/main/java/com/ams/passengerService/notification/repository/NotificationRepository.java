package com.ams.passengerService.notification.repository;

import com.ams.passengerService.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

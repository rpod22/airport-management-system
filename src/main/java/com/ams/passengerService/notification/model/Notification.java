package com.ams.passengerService.notification.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;      // np. FLIGHT_DELAY, GATE_CHANGE, INFO
    private String recipient; // np. "staff", "passenger", "all"
    private String message;

    private LocalDateTime createdAt;

    public Notification() {}

    public Notification(String type, String recipient, String message) {
        this.type = type;
        this.recipient = recipient;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public void setMessage(String message) { this.message = message; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

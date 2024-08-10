package org.example;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Notification {

    private UUID id;
    private User user;
    private String text;
    private LocalDateTime createdAt;
    private Boolean isRead;

    private NotificationType type;


    public Notification(User user, String text, LocalDateTime createdAt,NotificationType type) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.text = text;
        this.createdAt = createdAt;
        this.isRead = false;
        this.type = type;
    }

}

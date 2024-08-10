package org.example;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Comment {

    private UUID id;
    private Tweet tweet;
    private User user;
    private String text;
    private LocalDateTime createdAt;

    public Comment(User user, Tweet tweet, String text, LocalDateTime createdAt) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.tweet = tweet;
        this.text = text;
        this.createdAt = createdAt;
    }

}

package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class Tweet {

    private UUID id;
    private User user;

    private String text;

    private LocalDateTime createdAt;
    private List<Comment> comments;

    private Set<User> likes;

    public Tweet(User user, String text, LocalDateTime createdAt) {
        this.id =  UUID.randomUUID();
        this.user = user;
        this.text = text;
        this.createdAt = createdAt;
        this.comments = new ArrayList<>();
        this.likes = new HashSet<>();

    }

    // functions here can be addlikes, addComents

    public void addLikes(User user) {
        likes.add(user);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }



}

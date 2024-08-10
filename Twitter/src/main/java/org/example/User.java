package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class User {


    private String username;

    private String pictureUrl;

    private Set<User> followers;

    private Set<User> following;

    private List<Tweet> tweets;

    private List<Tweet> likesTweets;

    private List<Tweet> commentedTweets;

    private List<Notification> notifications;

    public User(String username, String pictureUrl) {

        this.username = username;
        this.pictureUrl = pictureUrl;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.tweets = new ArrayList<>();
        this.likesTweets = new ArrayList<>();
        this.commentedTweets = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }


    // functiosn to be added
    /**
     * 1) createTweet
     * 2) likeTweet
     * 3) commenttweet
     * 4) add notification
     * 5) follow
     * 6) add follower
     */

    public void follow(User user) {
        following.add(user);
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public void addLikedTweet(Tweet tweet) {
        likesTweets.add(tweet);
    }

    public void addCommentedTweet(Tweet tweet) {
        commentedTweets.add(tweet);
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

//    @Override
//    public String toString(){
//        return toString(new HashSet<>());
//    }
//
//    private String toString(Set<User> visited) {
//        if(visited.contains(this)) {
//            return "User{...}";
//        }
//        visited.add(this);
//        return "User{" +
//                "username='" + username + '\'' +
//                ", pictureUrl='" + pictureUrl + '\'' +
//                ", followers=" + followers.stream().map(f -> f.username).collect(Collectors.toSet()) +
//                ", following=" + following.stream().map(f -> f.username).collect(Collectors.toSet()) +
//                ", tweets=" + tweets +
//                ", likesTweets=" + likesTweets +
//                ", commentedTweets=" + commentedTweets +
//                ", notifications=" + notifications +
//                '}';
//    }


}

package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import lombok.ToString;

@Data

public class Twitter {

    private Map<String, User> users;
    private Map<UUID, Tweet> tweets;
    private Map<String, List<Notification>> notifications;

    public Twitter() {
        this.users = new HashMap<>();
        this.tweets = new HashMap<>();
        this.notifications = new HashMap<>();
    }

    public void createUser(String username,String profilePic) {
        User user = new User(username,profilePic);
        users.put(username,user);
    }


    public void followUser(String followerUsername, String followingUsername ) {
        User follower = users.get(followerUsername);
        User followee = users.get(followingUsername);
        followee.addFollower(follower);
        follower.follow(followee);
    }


    public void createTweet(String username, String text) {
        User user = users.get(username);
        Tweet tweet = new Tweet(user,text, LocalDateTime.now());
//        List<Tweet> tweetList = new ArrayList<>();
//        tweetList.add(tweet);
//        user.setTweets(tweetList);
        user.addTweet(tweet);
        tweets.put(tweet.getId(),tweet);
        notifyFollowers(tweet);
    }

    public void likeTweet(String username,UUID tweetId) {
        User user = users.get(username);
        Tweet tweet = tweets.get(tweetId);
        tweet.addLikes(user);
        user.addLikedTweet(tweet);
        notifyUser(tweet.getUser(),tweet,NotificationType.LIKE);
    }

    public void commentTweet(String username,UUID tweetId, String text) {
        User user = users.get(username);
        Tweet tweet = tweets.get(tweetId);
        Comment comment = new Comment(user,tweet,text,LocalDateTime.now());
        tweet.addComment(comment);
        user.addCommentedTweet(tweet);
        notifyUser(tweet.getUser(),tweet,NotificationType.LIKE);


    }
//    public List<Tweet> searchTweets(String query) {
//        // search the tweets for the given query
//    }

//    public List<String> getTrendingHashtags() {
//        // retrieve the most popular hashtags
//    }

    private void notifyFollowers(Tweet tweet) {
        User user  = tweet.getUser();
        Set<User> userList = user.getFollowers();
//        List<Notification> userNotification = user.getNotifications();
        for(User follower : userList) {
            Notification notification = new Notification(follower, tweet.getText(), LocalDateTime.now(), NotificationType.TWEET);
            follower.addNotification(notification);
        }
    }

    private void notifyUser(User user, Tweet tweet, NotificationType type) {
        Notification notification = new Notification(user, tweet.getText(),LocalDateTime.now(),type);
        user.addNotification(notification);
    }

}

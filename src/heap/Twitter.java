package heap;

import java.util.*;

public class Twitter {
  public class Tweet {
    public int tweetId;
    public int time;

    public Tweet(int tweetId, int time) {
      this.tweetId = tweetId;
      this.time = time;
    }
  }

  public class TweetHistory {
    public int tweetId;
    public int time;
    public int userId;
    public int tweetIndex;

    public TweetHistory(int tweetId, int time, int userId, int tweetIndex) {
      this.tweetId = tweetId;
      this.time = time;
      this.userId = userId;
      this.tweetIndex = tweetIndex;
    }
  }

  int globalTime;
  Map<Integer, Set<Integer>> follows;
  Map<Integer, List<Tweet>> tweets;

  public Twitter() {
    this.globalTime = 0;
    follows = new HashMap<>();
    tweets = new HashMap<>();
  }


  public void postTweet(int userId, int tweetId) {
    globalTime++;
    if (tweets.get(userId) == null) {
      tweets.put(userId, new LinkedList<>());
    }

    if (follows.get(userId) == null) {
      follows.put(userId, new HashSet<>());
      follows.get(userId).add(userId);
    }
    tweets.get(userId).add(new Tweet(tweetId, globalTime));
  }

  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<TweetHistory> q = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
    Set<Integer> followees = follows.get(userId);
    if (Objects.isNull(followees) || followees.isEmpty()) {
      return List.of();
    }
    for (Integer followee : followees) {
      List<Tweet> currentTweets = tweets.get(followee);
      if (Objects.isNull(currentTweets) || currentTweets.isEmpty()) {
        continue;
      }
      Tweet latest = currentTweets.getLast();
      q.add(new TweetHistory(latest.tweetId, latest.time, followee, currentTweets.size() - 1));
    }
    List<Integer> res = new ArrayList<>();
    while (!q.isEmpty() && res.size() < 10) {
      TweetHistory current = q.poll();
      res.add(current.tweetId);
      if (current.tweetIndex - 1 >= 0) {
        Tweet previous = tweets.get(current.userId).get(current.tweetIndex - 1);
        q.add(new TweetHistory(previous.tweetId, previous.time, current.userId, current.tweetIndex - 1));
      }
    }

    return res;
  }

  public void follow(int followerId, int followeeId) {
    if (follows.get(followerId) == null) {
      follows.put(followerId, new HashSet<>());
      follows.get(followerId).add(followerId);
    }
    follows.get(followerId).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (follows.get(followerId) == null) {
      return;
    }
    if (followerId == followeeId) {
      return;
    }
    follows.get(followerId).remove(followeeId);
  }

  public static void main(String[] args) {
    Twitter t = new Twitter();
//    t.postTweet(1, 1);
//    System.out.println(t.getNewsFeed(1));
//    t.follow(2, 1);
//    System.out.println(t.getNewsFeed(2));
//    t.unfollow(2, 1);
//    System.out.println(t.getNewsFeed(2));
    System.out.println(t.getNewsFeed(1));
  }
}

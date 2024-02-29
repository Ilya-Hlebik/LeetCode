package Chapter_9_heap_priority_queue.lc_06_355_Design_Twitter;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Twitter twitter = new Twitter();
/*        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));*/

        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 3); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));
    }
}

class Twitter {
    Map<Integer, PriorityQueue<Map.Entry<Integer, Long>>> userTweetsMap = new HashMap<>();
    Map<Integer, Set<Integer>> followed = new HashMap<>();
    Long id = 0L;

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        Set<Integer> set = followed.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        id++;
        PriorityQueue<Map.Entry<Integer, Long>> minHeap = userTweetsMap.getOrDefault(userId, new PriorityQueue<>((Map.Entry.comparingByValue())));
        minHeap.add(Map.entry(tweetId, id));
        if (minHeap.size() > 10) {
            minHeap.poll();
        }
        userTweetsMap.put(userId, minHeap);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = followed.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        PriorityQueue<Map.Entry<Integer, Long>> minHeap = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (Integer integer : set) {
            Queue<Map.Entry<Integer, Long>> entries = userTweetsMap.get(integer);
            if (entries != null) {
                minHeap.addAll(entries);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty() && result.size() < 10) {
            result.add(minHeap.poll().getKey());
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> orDefault = followed.getOrDefault(followerId, new HashSet<>());
        orDefault.add(followeeId);
        followed.put(followerId, orDefault);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followed.containsKey(followerId)) {
            Set<Integer> flowersList = followed.get(followerId);
            flowersList.remove(followeeId);
        }
    }
}

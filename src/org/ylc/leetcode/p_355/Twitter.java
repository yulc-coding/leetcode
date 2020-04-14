package org.ylc.leetcode.p_355;

import java.util.*;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-04-13
 */
public class Twitter {
    /**
     * 存放关注的用户列表, userId, set<userId></>
     */
    private Map<Integer, Set<Integer>> followMap;

    /**
     * 用户发布的推特信息
     * userId, Tweet链表
     */
    private Map<Integer, Tweet> tweetMap;

    /**
     * 用于记录发文的顺序
     */
    private int index;

    /**
     * 链表
     */
    private static class Tweet {

        private int tweetId;

        private int index;

        private int count;

        private Tweet next;

        private Tweet prev;

        private Tweet last;

        public Tweet(int tweetId, int index) {
            this.tweetId = tweetId;
            this.index = index;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, index++);
        Tweet existsTweet = tweetMap.get(userId);
        if (existsTweet != null) {
            // 超过10条，把最后一条删掉
            if (existsTweet.count >= 10) {
                tweet.count = 10;
                Tweet lastTweet = existsTweet.last.prev;
                tweet.last = lastTweet;
                existsTweet.last = null;
                lastTweet.next = null;
            } else {
                tweet.count = existsTweet.count + 1;
                tweet.last = existsTweet.last;
            }
            tweet.prev = null;
            // 关联前后节点
            tweet.next = existsTweet;
            existsTweet.prev = tweet;
            existsTweet.last = null;
        } else {
            // 首条记录
            tweet.last = tweet;
            tweet.count = 1;
        }
        tweetMap.put(userId, tweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        // 获取用户关注列表
        Set<Integer> followers = followMap.get(userId);
        if (followers == null) {
            followers = new HashSet<>();
        }
        // 将自己加入列表
        followers.add(userId);
        return mergeTweet(followers);
    }

    /**
     * 合并多个链表，取前10条
     */
    private List<Integer> mergeTweet(Set<Integer> followers) {
        // 存放要展示的tweet, <index, tweetId>
        Map<Integer, Integer> topTweetMap = new HashMap<>(16);
        // 存放最新的10条记录，即index最大的10条记录 TODO 用自己的链表实现看看有没有提升
        List<Integer> indexList = new LinkedList<>();
        Tweet tweet;
        int i = 0;
        for (Integer follower : followers) {
            tweet = tweetMap.get(follower);
            // 遍历链表
            while (tweet != null) {
                // 超过10条记录，需要比较发文的先后
                if (indexList.size() >= 10) {
                    if (tweet.index < indexList.get(9)) {
                        tweet = tweet.next;
                        continue;
                    }
                    // 移除当前最小的值
                    topTweetMap.remove(indexList.get(9));
                    indexList.remove(9);
                }
                // 进行排序
                for (Integer index : indexList) {
                    if (tweet.index > index) {
                        break;
                    }
                    i++;
                }
                indexList.add(i, tweet.index);
                topTweetMap.put(tweet.index, tweet.tweetId);
                tweet = tweet.next;
                i = 0;
            }
        }
        if (indexList.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> tweetIds = new ArrayList<>();
        indexList.forEach(o -> tweetIds.add(topTweetMap.get(o)));
        return tweetIds;
    }


    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        // 添加被关注者
        Set<Integer> myFollows = followMap.computeIfAbsent(followerId, k -> new HashSet<>());
        myFollows.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> myFollows = followMap.get(followerId);
        if (myFollows == null) {
            return;
        }
        myFollows.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.follow(2, 1);

        twitter.postTweet(1, 0);
        twitter.postTweet(1, 1);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 4);
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 6);
        twitter.postTweet(1, 7);
        twitter.postTweet(1, 8);
        twitter.postTweet(1, 9);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 12);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 14);
        twitter.postTweet(1, 15);

        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
    }

}

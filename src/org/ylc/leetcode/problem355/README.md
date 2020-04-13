> 来源：力扣（LeetCode）  
> 链接：https://leetcode-cn.com/problems/design-twitter

## 355.设计推特
设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

* postTweet(userId, tweetId): 创建一条新的推文
* getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
* follow(followerId, followeeId): 关注一个用户
* unfollow(followerId, followeeId): 取消关注一个用户

### 分析


### 解题思路
* 使用全局变量`index`来区分推文发布先后，每次发布+1；
* 使用`HashMap`来维护用户关注列表，其中`key`为用户自身ID，`value`为所有关注的信息，存入HashSet中：
    > 关注即在对应的Set中新增指定的userId  
    取关即在对应的Set中删除指定的userId
* 使用`HashMap`来维护每个用户的推文信息，其中`key`为用户ID，`value`为推文信息的，这里使用链表。
    > 链表中保存推文对应的`tweetId`和`index`
* 展示的时候只取最新的10条推文，所以每个用户的推文信息只需要维护最新的10条（节省内存）：
    > 每次新增的时候在链表头部插入，如果链表长度大于10 ，移除尾部节点。
* 展示推文时，根据将自己的推和关注用户的推文合并取最新的10条记录；


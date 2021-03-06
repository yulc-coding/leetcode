> 来源：力扣（LeetCode）  
  链接：https://leetcode-cn.com/problems/binary-tree-right-side-view

## 199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

**示例**:
```
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

### 思路
#### 方案一：深度优先搜索
* 按照 根节点 -> 右子节点 -> 左子节点的顺序递归遍历树
* 将每一层首次出现的非null值放入结果级中

#### 方案二：广度优先搜索
* 层级遍历树，将所有非空节点放入队列中
* 队列中只保存一层的节点信息
* 根据当前层节点数量去遍历并取出当前层的节点
* 将下一层的节点数量放入队列中
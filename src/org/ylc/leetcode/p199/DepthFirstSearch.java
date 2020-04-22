package org.ylc.leetcode.p199;

import java.util.*;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 199. 二叉树的右视图
 * 执行用时 : 3 ms, 在所有 Java 提交中击败了 8.10% 的用户
 * 内存消耗 : 38.6 MB, 在所有 Java 提交中击败了 5.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/22
 */
public class DepthFirstSearch {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 存放每层对应的最右节点的值， k,v -> 层数，最右边的非null值
        Map<Integer, Integer> rightSideMap = new HashMap<>();
        // 最大深度
        int maxDepth = 0;
        // 记录几点
        Stack<TreeNode> nodeStack = new Stack<>();
        // 记录当前节点对应的深度
        Stack<Integer> depthStack = new Stack<>();
        // 初始化根节点
        nodeStack.push(root);
        depthStack.push(0);

        TreeNode curNode;
        int curDepth;
        while (!nodeStack.isEmpty()) {
            curNode = nodeStack.pop();
            curDepth = depthStack.pop();
            if (curNode != null) {
                // 重置最大深度
                maxDepth = Math.max(maxDepth, curDepth);
                // 只记录第一次出现的值，即最右边的值
                if (!rightSideMap.containsKey(curDepth)) {
                    rightSideMap.put(curDepth, curNode.val);
                }
                // 后入先出，所以要先放left
                nodeStack.push(curNode.left);
                depthStack.push(curDepth + 1);

                nodeStack.push(curNode.right);
                depthStack.push(curDepth + 1);
            }
        }
        // 按层数获取对应的值
        for (int depth = 0; depth <= maxDepth; depth++) {
            result.add(rightSideMap.get(depth));
        }
        return result;
    }

}

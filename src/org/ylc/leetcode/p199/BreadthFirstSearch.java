package org.ylc.leetcode.p199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 199. 二叉树的右视图
 * 广度优先搜索（层级遍历）
 * 执行用时 : 1 ms, 在所有 Java 提交中击败了 97.36% 的用户
 * 内存消耗 : 38.3 MB, 在所有 Java 提交中击败了 5.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/22
 */
public class BreadthFirstSearch {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 存放非空节点
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // 初始化根节点
        nodeQueue.add(root);

        TreeNode curNode;
        // 当前层数队列的长度
        int nodeSize;
        while (!nodeQueue.isEmpty()) {
            nodeSize = nodeQueue.size();
            // 循环遍历，取出当前层的节点，并放入下一层的节点
            for (int i = 0; i < nodeSize; i++) {
                curNode = nodeQueue.remove();
                // 首次出现的放入结果集中
                if (i == 0) {
                    result.add(curNode.val);
                }
                // 优先存放右节点
                if (curNode.right != null) {
                    nodeQueue.add(curNode.right);
                }
                if (curNode.left != null) {
                    nodeQueue.add(curNode.left);
                }
            }
        }
        return result;
    }

}

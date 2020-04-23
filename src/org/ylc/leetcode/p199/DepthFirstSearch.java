package org.ylc.leetcode.p199;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 199. 二叉树的右视图
 * 深度优先搜索，优先右节点
 * 执行用时 : 1 ms, 在所有 Java 提交中击败了 97.36% 的用户
 * 内存消耗 : 38.4 MB, 在所有 Java 提交中击败了 5.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/22
 */
public class DepthFirstSearch {

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root != null) {
            // 根节点深度为0
            dfs(root, 0);
        }
        return result;
    }

    /**
     * 按照 根节点 -> 右子节点 -> 左子节点的顺序遍历
     */
    private void dfs(TreeNode root, int depth) {
        // 将当前层数的首个（即最右边的放入结果中）
        if (result.size() == depth) {
            result.add(root.val);
        }
        depth++;
        // 优先访问右边子节点
        if (root.right != null) {
            dfs(root.right, depth);
        }
        if (root.left != null) {
            dfs(root.left, depth);
        }
    }
}

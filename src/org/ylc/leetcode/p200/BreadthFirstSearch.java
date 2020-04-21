package org.ylc.leetcode.p200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 广度优先搜索
 * 执行用时 : 6 ms, 在所有 Java 提交中击败了 23.80% 的用户
 * 内存消耗 : 42.3 MB, 在所有 Java 提交中击败了 6.25% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/21
 */
public class BreadthFirstSearch {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;

        int lands = 0;

        // 创建队列存放岛屿的坐标
        Queue<Integer> queue = new LinkedList<>();
        int queueRow, queueCol;

        for (int curRow = 0; curRow < rows; curRow++) {
            for (int curCol = 0; curCol < cols; curCol++) {
                if (grid[curRow][curCol] == '1') {
                    lands++;
                    // 清空
                    grid[curRow][curCol] = '0';
                    // 将岛屿根节点放入队列中
                    queue.add(curRow * cols + curCol);
                    while (!queue.isEmpty()) {
                        int removed = queue.remove();
                        queueRow = removed / cols;
                        queueCol = removed % cols;
                        // 向上
                        if (queueRow - 1 >= 0 && grid[queueRow - 1][queueCol] == '1') {
                            grid[queueRow - 1][queueCol] = '0';
                            queue.add((queueRow - 1) * cols + queueCol);
                        }
                        // 向下
                        if (queueRow + 1 < rows && grid[queueRow + 1][queueCol] == '1') {
                            grid[queueRow + 1][queueCol] = '0';
                            queue.add((queueRow + 1) * cols + queueCol);
                        }
                        // 向左
                        if (queueCol - 1 >= 0 && grid[queueRow][queueCol - 1] == '1') {
                            grid[queueRow][queueCol - 1] = '0';
                            queue.add(queueRow * cols + queueCol - 1);
                        }
                        // 向右
                        if (queueCol + 1 < cols && grid[queueRow][queueCol + 1] == '1') {
                            grid[queueRow][queueCol + 1] = '0';
                            queue.add(queueRow * cols + queueCol + 1);
                        }
                    }
                }
            }
        }
        return lands;
    }

}

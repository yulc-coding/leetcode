package org.ylc.leetcode.p200;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 深度优先搜索
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/20
 */
public class DepthFirstSearch {

    public int numIslands(char[][] grid) {
        int h = grid.length;
        if (h == 0) {
            return 0;
        }
        int w = grid[0].length;
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, h, w);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int curH, int curW, int maxH, int maxW) {
        if (curH < 0 || curW < 0 || curH >= maxH || curW >= maxW || grid[curH][curW] == '0') {
            return;
        }
        grid[curH][curW] = '0';

        dfs(grid, curH, curW - 1, maxH, maxW);
        dfs(grid, curH, curW + 1, maxH, maxW);
        dfs(grid, curH - 1, curW, maxH, maxW);
        dfs(grid, curH + 1, curW, maxH, maxW);
    }

}

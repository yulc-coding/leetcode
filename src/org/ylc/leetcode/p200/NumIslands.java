package org.ylc.leetcode.p200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 200. 岛屿数量
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/20
 */
public class NumIslands {

    public int run(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;

        int result = 0;
        // 存放岛屿关联的位置，如果当前位置为1，则存放右边和下边为1的坐标
        Map<Integer, Integer> landMap = new HashMap<>();
        // 重复岛屿信息，2个岛屿公用一个点，需要合并（防止出现重复关联：A->B,B->A，以小的值作为key）
        Map<Integer, Set<Integer>> repeatMap = new HashMap<>();
        Set<Integer> repeatSet;
        // 被重复的岛屿信息，如A->B 重复，记录 B
        Set<Integer> beRepeatSet = new HashSet<>();
        // 多次重复的次数， 如 A-> B, B->C ,存在两条重复记录，实际ABC应该是一个岛屿
        int multipleRepeat = 0;
        // 岛屿的起始点
        int landRoot;
        // 已关联的岛屿起始点
        int existsLand;
        // 假设如果左边和上边都是0，说明这是一个新的岛屿，（实际不是，后面需要去重）
        for (int curRow = 0; curRow < rows; curRow++) {
            for (int curCol = 0; curCol < cols; curCol++) {
                if (grid[curRow][curCol] == '0') {
                    continue;
                }
                // 非新的岛屿，获取当前岛屿的起始点并清理当前坐标
                if (landMap.containsKey(curRow * cols + curCol)) {
                    landRoot = landMap.get(curRow * cols + curCol);
                    landMap.remove(curRow * cols + curCol);
                } else {
                    // 新岛屿
                    result++;
                    landRoot = curRow * cols + curCol;
                }
                // 下边为1的
                if (curRow < rows - 1 && grid[curRow + 1][curCol] == '1') {
                    landMap.put((curRow + 1) * cols + curCol, landRoot);
                }
                // 右边为1的，右边的点可能已经和右边上边岛屿关联的
                if (curCol < cols - 1 && grid[curRow][curCol + 1] == '1') {
                    if (!landMap.containsKey(curRow * cols + curCol + 1)) {
                        landMap.put(curRow * cols + curCol + 1, landRoot);
                        continue;
                    }
                    // 判断是否2个岛屿公用这个点，记录重复信息
                    existsLand = landMap.get(curRow * cols + curCol + 1);
                    if (landRoot != existsLand) {
                        // 防止出现重复关联，用小的值作为key
                        repeatSet = repeatMap.computeIfAbsent(Math.min(existsLand, landRoot), k -> new HashSet<>());
                        repeatSet.add(Math.max(existsLand, landRoot));
                        // 添加被重复记录
                        beRepeatSet.add(Math.max(existsLand, landRoot));
                        // 是否存在链式重复关系
                        if (beRepeatSet.contains(Math.min(existsLand, landRoot))) {
                            multipleRepeat++;
                        }
                    }
                }
            }
        }
        System.out.println(multipleRepeat);
        // 去重
        for (Set<Integer> repeatLands : repeatMap.values()) {
            result -= repeatLands.size();
        }
        return result + multipleRepeat;
    }

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.run(grid));
    }
}

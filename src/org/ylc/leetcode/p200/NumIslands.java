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
        int h = grid.length;
        if (h == 0) {
            return 0;
        }
        int w = grid[0].length;

        int result = 0;
        // 存放岛屿关联的位置，如果当前位置为1，则存放右边和下边为1的坐标
        Map<Integer, Integer> landMap = new HashMap<>();
        // 重复岛屿信息，2个岛屿公用一个点，需要合并（防止出现重复关联：A->B,B->A，以小的值作为key）
        Map<Integer, Set<Integer>> repeatMap = new HashMap<>();
        Set<Integer> repeatSet;
        // 岛屿的起始点
        int landIndex;
        // 已存在的岛屿起始点
        int existsLandIndex;
        // 如果左边和上边都是0，说明这是一个新的岛屿
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                // 非新的岛屿，获取当前岛屿的起始点并清理当前坐标
                if (landMap.containsKey(i * w + j)) {
                    landIndex = landMap.get(i * w + j);
                    landMap.remove(i * w + j);
                } else {
                    // 新岛屿
                    result++;
                    landIndex = i * w + j;
                }
                if (i == 1 && j == 2) {
                    System.out.println(1);
                }
                // 下边为1的
                if (i < h - 1 && grid[i + 1][j] == '1') {
                    landMap.put((i + 1) * w + j, landIndex);
                }
                // 右边为1的
                if (j < w - 1 && grid[i][j + 1] == '1') {
                    if (!landMap.containsKey(i * w + j + 1)) {
                        landMap.put(i * w + j + 1, landIndex);
                        continue;
                    }
                    // 判断是否2个岛屿公用这个点，记录重复信息
                    existsLandIndex = landMap.get(i * w + j + 1);
                    if (landIndex != existsLandIndex) {
                        // 防止出现重复关联，用小的值作为key
                        if (existsLandIndex < landIndex) {
                            repeatSet = repeatMap.computeIfAbsent(existsLandIndex, k -> new HashSet<>());
                            repeatSet.add(landIndex);
                        } else {
                            repeatSet = repeatMap.computeIfAbsent(landIndex, k -> new HashSet<>());
                            repeatSet.add(existsLandIndex);
                        }
                    }
                }
            }
        }
        // 去重
        for (Set<Integer> repeatLands : repeatMap.values()) {
            result -= repeatLands.size();
        }
        return result;
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

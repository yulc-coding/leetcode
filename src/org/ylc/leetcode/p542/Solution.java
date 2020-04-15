package org.ylc.leetcode.p542;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 执行用时 : 8 ms, 在所有 Java 提交中击败了 94.93% 的用户
 * 内存消耗 : 42.8 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-04-15
 */
public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        // 矩阵纵向的个数(行数)
        int height = matrix.length;
        // 获取矩阵横向的个数（列数）
        int width = matrix[0].length;
        // 当前外围圈数，也表示可能的最小距离
        int circle = 1;
        // 最小距离
        int min = 0;
        // 当前比较的值位置
        int w, h;
        // 用于比较的最大边界位置
        int maxCheckHeight, maxCheckWidth;

        int[][] result = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 当前位置为0，距离为0
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    continue;
                }
                h = Math.max(i - circle, 0);
                w = Math.max(j - circle, 0);
                maxCheckHeight = Math.min(i + circle, height - 1);
                maxCheckWidth = Math.min(j + circle, width - 1);
                while (h <= maxCheckHeight) {
                    // 换一行
                    if (w > maxCheckWidth) {
                        w = Math.max(j - circle, 0);
                        h++;
                        continue;
                    }
                    if (matrix[h][w] == 0) {
                        int distance = Math.abs(h - i) + Math.abs(w - j);
                        if (min == 0) {
                            min = distance;
                        } else {
                            min = Math.min(min, distance);
                        }
                        if (min == circle) {
                            break;
                        }
                    }
                    // 当前外围圈内没有0，获取下一圈的值
                    if (w == maxCheckWidth && h == maxCheckHeight) {
                        circle++;
                        h = Math.max(i - circle, 0);
                        w = Math.max(j - circle, 0);
                        maxCheckHeight = Math.min(i + circle, height - 1);
                        maxCheckWidth = Math.min(j + circle, width - 1);
                        continue;
                    }
                    w++;
                }
                result[i][j] = min;
                circle = 1;
                min = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        };
        Solution s = new Solution();
        int[][] result = s.updateMatrix(matrix);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }

}

package org.ylc.leetcode.p56;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * 56. 合并区间
 * 执行用时 : 2 ms, 在所有 Java 提交中击败了 99.57% 的用户
 * 内存消耗 : 42.3 MB, 在所有 Java 提交中击败了 42.46% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/16
 */
public class Merge {

    public int[][] run(int[][] intervals) {
        // 行数
        int h = intervals.length;
        // 当前区间的最小值和最大值
        int min, max;
        // 需要移除的行数
        int remove = 0;
        // 每一行数组和后面所有数组进行比较，如果有重叠的，重置区间，并把后面的数组设为null
        for (int i = 0; i < h; i++) {
            if (intervals[i] == null) {
                remove++;
                continue;
            }
            min = intervals[i][0];
            max = intervals[i][1];
            // 如果数组边界重置了，需要重新和其他的数组比较
            for (int j = i + 1; j < h; j++) {
                if (intervals[j] == null) {
                    continue;
                }
                if (min <= intervals[j][0]) {
                    // 重置最大边界
                    if (max >= intervals[j][0] && max <= intervals[j][1]) {
                        max = intervals[j][1];
                        intervals[i] = new int[]{min, max};
                        intervals[j] = null;
                        j = i;
                        continue;
                    }
                    // 包含在内了
                    if (max >= intervals[j][1]) {
                        intervals[j] = null;
                        continue;
                    }
                }
                if (min >= intervals[j][0]) {
                    // 重置最小边界
                    if (min <= intervals[j][1] && max >= intervals[j][1]) {
                        min = intervals[j][0];
                        intervals[i] = new int[]{min, max};
                        intervals[j] = null;
                        j = i;
                        continue;
                    }
                    // 重置最大和最小边界
                    if (max <= intervals[j][1]) {
                        intervals[i] = intervals[j];
                        min = intervals[i][0];
                        max = intervals[i][1];
                        intervals[j] = null;
                        j = i;
                    }
                }
            }
        }
        // 将不是null的数据返回
        int[][] result = new int[h - remove][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (interval == null) {
                continue;
            }
            result[index++] = interval;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        };
        Merge merge = new Merge();
        int[][] result = merge.run(intervals);
        for (int[] arr : result) {
            for (int i : arr) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }
}

package org.ylc.leetcode.p56;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 先排序，
 * 前后数组对比是否重叠
 * 有重叠的，重置最大区间，并将合并后的数组设为NULL,
 * 去除数组中的NULL数组，返回
 * <p>
 * 排序耗时久
 * <p>
 * 56. 合并区间
 * 执行用时 : 8 ms, 在所有 Java 提交中击败了 70.82% 的用户
 * 内存消耗 : 42.5 MB, 在所有 Java 提交中击败了 38.35% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-04-16
 */
public class Merge3 {

    public int[][] run(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        int h = intervals.length;
        // 按左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 需要移除的数量
        int remove = 0;
        // 用于比较的最后一位的索引
        int lastIndex = 0;

        for (int i = 0; i < h; i++) {
            // 首位，直接跳过
            if (i == 0) {
                continue;
            }
            // 当前区间的最小边界 > 已有区间的最后一个的最大边界
            if (intervals[i][0] > intervals[lastIndex][1]) {
                lastIndex = i;
                continue;
            }
            // 存在重叠，最大边界判断
            intervals[lastIndex][1] = Math.max(intervals[lastIndex][1], intervals[i][1]);
            intervals[i] = null;
            remove++;
        }
        // 去除null的数组
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
        Merge3 merge2 = new Merge3();
        int[][] result = merge2.run(intervals);
        for (int[] arr : result) {
            for (int i : arr) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

}

package org.ylc.leetcode.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 先排序，
 * 将合并后的有效区间存入List
 * 将List转化为数组返回
 * <p>
 * 排序耗时久，list处理耗时
 * <p>
 * 56. 合并区间
 * 执行用时 : 14 ms, 在所有 Java 提交中击败了 21.44% 的用户
 * 内存消耗 : 42.4 MB, 在所有 Java 提交中击败了 39.72% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-04-16
 */
public class Merge2 {

    public int[][] run(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        // 按左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> array = new ArrayList<>();
        int lastIndex = 0;
        int[] lastArray;
        for (int[] interval : intervals) {
            // 为空，直接放入
            if (array.size() == 0) {
                array.add(interval);
                continue;
            }
            lastArray = array.get(lastIndex);
            // 当前区间的最小边界 > 已有区间的最后一个的最大边界
            if (interval[0] > lastArray[1]) {
                array.add(interval);
                lastIndex++;
                continue;
            }
            // 有交集的需要判断最大边界
            lastArray[1] = Math.max(lastArray[1], interval[1]);
        }
        return array.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        };
        Merge2 merge2 = new Merge2();
        int[][] result = merge2.run(intervals);
        for (int[] arr : result) {
            for (int i : arr) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

}

package org.ylc.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 1. 两数之和
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-04-19
 */
public class TwoSum {

    public int[] run(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int first;
        for (int second : nums) {
            first = target - second;
            if (map.containsKey(first)) {
                return new int[]{map.get(first), index};
            }
            map.put(second, index++);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.run(nums, 9);
        for (int i : result) {
            System.out.print(i);
        }
    }
}

package org.ylc.leetcode.p1248;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 1248. 统计「优美子数组」
 * 执行用时 : 16 ms, 在所有 Java 提交中击败了 45.93% 的用户
 * 内存消耗 : 48.4 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/21
 */
public class NumberOfSubArrays {

    public int run(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // 保存所有奇数的索引
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 奇数
            if (nums[i] % 2 > 0) {
                oddList.add(i);
            }
        }
        if (oddList.size() < k) {
            return 0;
        }
        int result = 0;
        // 奇数最左和最右的索引
        int oddLeft, oddRight;
        // 子数组最小索引，前一个奇数的后一个位置
        int minLeft = 0;
        // 子数组最大索引：下一个奇数的前一个位置
        int maxRight;
        int move = 0;
        while (k + move <= oddList.size()) {
            oddLeft = oddList.get(move);
            oddRight = oddList.get(k - 1 + move);
            // 移动到最后一个奇数，子数组最大索引为原数组最后
            if (k + move == oddList.size()) {
                maxRight = length - 1;
            } else {
                maxRight = oddList.get(k + move) - 1;
            }
            result += (oddLeft - minLeft + 1) * (maxRight - oddRight + 1);
            move++;
            minLeft = oddLeft + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        NumberOfSubArrays numberOfSubArrays = new NumberOfSubArrays();
        System.out.println(numberOfSubArrays.run(nums, k));
    }
}

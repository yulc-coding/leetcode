package org.ylc.leetcode.Interview.p56_1;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 面试题56 - I. 数组中数字出现的次数
 * <p>
 * 执行用时 : 2 ms, 在所有 Java 提交中击败了 95.47% 的用户
 * 内存消耗 : 41.4 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/28
 */
public class SingleNumbers {

    public int[] run(int[] nums) {
        // 存放所有数异或后的结果，即2个唯一数的异或值
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        // 获取异或结果二进制中右起第一个为1的位置
        int bitIndex = 1;
        while ((temp & bitIndex) == 0) {
            // 左移1一位
            bitIndex <<= 1;
        }
        // 唯一数
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & bitIndex) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 10, 4, 1, 4, 3, 3};

        SingleNumbers singleNumbers = new SingleNumbers();
        int[] result = singleNumbers.run(nums);
        System.out.printf("[%d,%d]", result[0], result[1]);
    }

}

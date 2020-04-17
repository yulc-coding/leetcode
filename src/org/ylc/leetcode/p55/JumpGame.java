package org.ylc.leetcode.p55;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 55 跳跃游戏
 * 执行用时 : 2 ms, 在所有 Java 提交中击败了 65.41% 的用户
 * 内存消耗 : 41.5 MB, 在所有 Java 提交中击败了 14.06% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/17
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        // 需要跳跃的步数
        int steps = nums.length - 1;
        // 当前跳跃最大距离
        int max = 0;
        int index = 0;
        for (int num : nums) {
            // 无法到达当前位置
            if (max < index) {
                return false;
            }
            // 重置最大跳跃步数
            max = Math.max(max, index + num);
            // 最大跳跃距离
            if (max >= steps) {
                return true;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(nums));
    }
}

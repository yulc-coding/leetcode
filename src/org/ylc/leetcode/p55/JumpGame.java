package org.ylc.leetcode.p55;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 55 跳跃游戏
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/17
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int index = 0;
        int max = 0;
        for (int num : nums) {
            if (max < index) {
                return false;
            }
            max = Math.max(max, index + num);
            index++;
        }
        return true;
    }
}

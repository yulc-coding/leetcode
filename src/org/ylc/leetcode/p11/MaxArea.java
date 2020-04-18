package org.ylc.leetcode.p11;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 11. 盛最多水的容器
 * 执行用时 : 4 ms, 在所有 Java 提交中击败了 75.62% 的用户
 * 内存消耗 : 39.9 MB, 在所有 Java 提交中击败了 37.86% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-04-18
 */
public class MaxArea {

    public int run(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[right] > height[left]) {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            } else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] height = new int[]{1, 1};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.run(height));

    }

}

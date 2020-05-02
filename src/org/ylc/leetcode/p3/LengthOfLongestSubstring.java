package org.ylc.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 3. 无重复字符的最长子串
 * 执行用时 : 9 ms, 在所有 Java 提交中击败了 62.69% 的用户
 * 内存消耗 : 40.6 MB, 在所有 Java 提交中击败了 5.20% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-05-02
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        // 滑动窗口的边界
        int leftIndex = 0, rightIndex = 0;
        // 最大长度
        int maxLength = 0;
        char[] chars = s.toCharArray();
        // 存放不重复的值
        Set<Character> charSet = new HashSet<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            // 如果当前值已近存在了
            while (charSet.contains(chars[i])) {
                // 移除当前左边界对应的字符，并且左边界右移
                charSet.remove(chars[leftIndex++]);
            }
            // 赋值右边界为当前位置
            rightIndex = i;
            // 记录当前字符
            charSet.add(chars[rightIndex]);
            // 更新最大长度，需要额外加1：[0,2]对应长度为3
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }

}

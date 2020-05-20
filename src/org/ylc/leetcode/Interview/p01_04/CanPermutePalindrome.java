package org.ylc.leetcode.Interview.p01_04;

import java.util.HashSet;
import java.util.Set;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 面试题 01.04. 回文排列
 *
 * 执行用时 : 1 ms, 在所有 Java 提交中击败了 74.59% 的用户
 * 内存消耗 : 37.4 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/5/20
 */
public class CanPermutePalindrome {

    public boolean run(String s) {
        char[] chars = s.toCharArray();
        // 存放字符
        Set<Character> charSet = new HashSet<>();
        for (char c : chars) {
            // 已近存在了
            if (charSet.contains(c)) {
                charSet.remove(c);
            } else {
                charSet.add(c);
            }
        }
        return charSet.size() <= 1;
    }

    public static void main(String[] args) {
        CanPermutePalindrome canPermutePalindrome = new CanPermutePalindrome();
        System.out.println(canPermutePalindrome.run("code"));
    }

}

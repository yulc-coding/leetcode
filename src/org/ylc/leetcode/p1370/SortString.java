package org.ylc.leetcode.p1370;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 1370. 上升下降字符串
 * 执行用时 : 3 ms, 在所有 Java 提交中击败了 97.79% 的用户
 * 内存消耗 : 39.9 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/6/16
 */
public class SortString {

    public String run(String s) {
        // 统计每个字符出现的次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 返回的新字符串
        StringBuilder str = new StringBuilder();
        int newLength = 0;
        while (newLength < s.length()) {
            // a -> z
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    str.append((char) ('a' + i));
                    count[i]--;
                    newLength++;
                }
            }
            // z -> a
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    str.append((char) ('a' + i));
                    count[i]--;
                    newLength++;
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        SortString sortString = new SortString();
        System.out.println(sortString.run("leetcode"));
    }

}

package org.ylc.leetcode.p67;

import java.util.Stack;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 67. 二进制求和
 * 执行用时 : 3 ms, 在所有 Java 提交中击败了 55.55% 的用户
 * 内存消耗 : 39.7 MB, 在所有 Java 提交中击败了 7.69% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/6/23
 */
public class AddBinary {

    public String run(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            stack.push(carry % 2);
            carry /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.run("1010", "1011"));
    }

}

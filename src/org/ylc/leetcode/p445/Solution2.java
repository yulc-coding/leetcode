package org.ylc.leetcode.p445;

import java.util.Stack;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 方案二：
 * `栈`实现了后进先出，通过`栈`可以将`链表`中的值进行翻转，使数字按照从低位到高位的顺序
 * 定义两个栈，将链表的值存入栈中
 * 两个栈分别pop()进行相加
 * <p>
 * 执行用时 : 10 ms, 在所有 Java 提交中击败了 7.08% 的用户
 * 内存消耗 : 40.7 MB, 在所有 Java 提交中击败了 95.83% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/14
 */
public class Solution2 {

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // 求和
        int sum = 0;
        // 进位
        int carry = 0;
        ListNode node = null;
        while (!stack1.empty() || !stack2.empty() || carry > 0) {
            if (!stack1.empty()) {
                sum += stack1.pop();
            }
            if (!stack2.empty()) {
                sum += stack2.pop();
            }
            if (carry > 0) {
                sum += carry;
                carry = 0;
            }
            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            }
            ListNode curNode = new ListNode(sum);
            curNode.next = node;
            node = curNode;
            sum = 0;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        Solution2 s = new Solution2();
        ListNode node = s.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

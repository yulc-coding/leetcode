package org.ylc.leetcode.p2;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 2. 两数相加
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-05-06
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode tagNode = node;
        // 进位
        int carry = 0;
        // 相加的和
        int sum = 0;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry > 0) {
                sum += carry;
                carry = 0;
            }
            // > 10 进位处理
            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            }
            ListNode curNode = new ListNode(sum);
            tagNode.next = curNode;
            tagNode = curNode;
            sum = 0;
        }
        return node.next;
    }

}

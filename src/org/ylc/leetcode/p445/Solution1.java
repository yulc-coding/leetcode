package org.ylc.leetcode.p445;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 方案一：
 * 先获取到相加的2个值，然后把求和结果放入链表中
 * 7243 = 7*1000 + 2*100 + 4*10 + 3*1
 * 564 = 5 *100 + 6*10 + 4*1
 * <p>
 * 执行用时 : 10 ms, 在所有 Java 提交中击败了 7.08% 的用户
 * 内存消耗 : 40.7 MB, 在所有 Java 提交中击败了 95.83% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/14
 */
public class Solution1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal x = getNumber(l1);
        BigDecimal y = getNumber(l2);
        BigDecimal sum = x.add(y);
        String sumStr = sum.toPlainString();
        ListNode rootNode = new ListNode(0);
        ListNode tempNode = rootNode;
        for (int i = 0, length = sumStr.length(); i < length; i++) {
            ListNode curNode = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(i))));
            tempNode.next = curNode;
            tempNode = curNode;
        }
        return rootNode.next;
    }

    /**
     * 将链表转换为对应的数值
     * 需要用 BigDecimal，不然长度会超
     */
    private BigDecimal getNumber(ListNode l1) {
        BigDecimal number = BigDecimal.ZERO;
        List<Integer> numbers = new ArrayList<>();
        while (l1 != null) {
            numbers.add(l1.val);
            l1 = l1.next;
        }
        for (Integer nu : numbers) {
            // 将原先的值 * 10 + 对应的值
            number = number.multiply(BigDecimal.TEN).add(new BigDecimal(nu));
        }
        return number;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(7);

        Solution1 s = new Solution1();
        ListNode node = s.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

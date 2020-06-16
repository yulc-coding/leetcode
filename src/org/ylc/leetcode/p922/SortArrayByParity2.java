package org.ylc.leetcode.p922;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 922. 按奇偶排序数组 II
 * 执行用时 : 3 ms, 在所有 Java 提交中击败了 79.83% 的用户
 * 内存消耗 : 42.7 MB, 在所有 Java 提交中击败了 9.09% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/6/16
 */
public class SortArrayByParity2 {

    public int[] run(int[] A) {
        int[] result = new int[A.length];
        int evenIndex = 0;
        int oddIndex = 1;
        for (int i : A) {
            if (i % 2 == 0) {
                result[evenIndex] = i;
                evenIndex += 2;
            } else {
                result[oddIndex] = i;
                oddIndex += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 5, 7};
        SortArrayByParity2 sortArrayByParity2 = new SortArrayByParity2();
        int[] result = sortArrayByParity2.run(a);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

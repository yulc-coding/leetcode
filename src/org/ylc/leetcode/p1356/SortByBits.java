package org.ylc.leetcode.p1356;

import java.util.Arrays;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 1356. 根据数字二进制下 1 的数目排序
 * 执行用时 : 3 ms, 在所有 Java 提交中击败了 99.89% 的用户
 * 内存消耗 : 39.7 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/6/22
 */
public class SortByBits {

    public int[] run(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100000 + arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] % 100000;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        SortByBits sortByBits = new SortByBits();
        int[] result = sortByBits.run(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

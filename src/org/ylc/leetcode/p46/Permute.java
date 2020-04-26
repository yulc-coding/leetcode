package org.ylc.leetcode.p46;

import java.util.*;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 46. 全排列
 * 执行用时 : 3 ms, 在所有 Java 提交中击败了 45.73% 的用户
 * 内存消耗 : 39.9 MB, 在所有 Java 提交中击败了 7.32% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/25
 */
public class Permute {

    /**
     * 数组长度
     */
    int len;

    /**
     * 存在的排列组合
     */
    List<Integer> combination;

    /**
     * 结果集
     */
    List<List<Integer>> result;

    public List<List<Integer>> run(int[] nums) {
        len = nums.length;
        if (len == 0) {
            return Collections.emptyList();
        }
        // 初始化长度，避免频繁扩容导致的消耗
        result = new ArrayList<>(resultSize(len));
        combination = new ArrayList<>();

        // 记录数组中每个位置的数是否已经使用了。这里用位数组，减少存储空间
        BitSet bitUsed = new BitSet(len);

        dfs(nums, 0, bitUsed);
        return result;
    }

    /**
     * 获取所有组合的个数即数组长度的阶乘：n!
     */
    private int resultSize(int arrLen) {
        int resultSize = 1;
        while (arrLen > 0) {
            resultSize *= arrLen;
            arrLen--;
        }
        return resultSize;
    }


    private void dfs(int[] nums, int curCombLen, BitSet bitUsed) {
        // 当前组个的长度和数组长度一致，说明所有数都已经放入组合中了
        if (curCombLen == len) {
            // combination是公用的，这里需要将combination复制一份放入结果
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!bitUsed.get(i)) {
                combination.add(nums[i]);
                bitUsed.set(i);

                dfs(nums, curCombLen + 1, bitUsed);

                // 回溯操作，回退到
                bitUsed.clear(i);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permute permute = new Permute();

        List<List<Integer>> res = permute.run(nums);
        res.forEach(System.out::println);
    }
}

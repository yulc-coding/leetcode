package org.ylc.leetcode.p621;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 队列
 * 621 任务调度器
 * 执行用时 : 11 ms, 在所有 Java 提交中击败了 25.16% 的用户
 * 内存消耗 : 40.1 MB, 在所有 Java 提交中击败了 36.91% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-04-15
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {
        int length = tasks.length;
        if (length == 1) {
            return 1;
        }
        if (n == 0) {
            return length;
        }
        // 存放任务种类
        Set<Character> taskSet = new HashSet<>();
        // 初始化每个任务对应个数的数组
        int[] taskNumbers = new int[26];
        for (char task : tasks) {
            taskNumbers[task - 'A']++;
            taskSet.add(task);
        }
        // 排序
        Arrays.sort(taskNumbers);
        // 任务种类，不够一轮的
        if (taskSet.size() <= (n + 1)) {
            return taskLessThenOneRound(taskNumbers, n);
        }
        // 任务种类大于一轮所需要的任务数
        return taskMoreThenOneRound(taskNumbers, n);
    }

    /**
     * 任务种类少于一轮需要的任务数
     * <p>
     * 前面每一轮耗时为 n+1
     * 最后一轮看最后剩余的任务种类决定
     */
    private int taskLessThenOneRound(int[] taskNumbers, int n) {
        int roundNumber = taskNumbers[25];
        // 前几轮耗时
        int times = (roundNumber - 1) * (n + 1);
        // 最后一轮剩余的任务种类（即任务出现次数并列最多的任务种类）
        for (int i = 25; i >= 0; i--) {
            if (taskNumbers[i] < roundNumber) {
                break;
            }
            times++;
        }
        return times;
    }

    /**
     * 任务种类大于一轮需要的任务数
     * 每一轮都从出现次数最大的任务开始排列
     */
    private int taskMoreThenOneRound(int[] taskNumbers, int n) {
        int times = 0;
        // 本轮已近使用的任务数
        int i = 0;
        // 当任任务出现最多的次数为0时，说明所有任务都排列结束
        while (taskNumbers[25] > 0) {
            // 一轮循环
            while (i <= n) {
                if (taskNumbers[25] == 0) {
                    break;
                }
                // 最多26个任务，超过的全部等待
                if (i <= 25 && taskNumbers[25 - i] > 0) {
                    taskNumbers[25 - i]--;
                }
                times++;
                i++;
            }
            Arrays.sort(taskNumbers);
            i = 0;
        }
        return times;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(solution.leastInterval(tasks, 1));
    }
}

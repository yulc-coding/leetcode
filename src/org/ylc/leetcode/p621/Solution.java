package org.ylc.leetcode.p621;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
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
        int times = 0;
        // 存放每个任务对应的个数
        Map<Character, Integer> taskMap = new HashMap<>();
        int numbers = 0;
        for (char task : tasks) {
            if (taskMap.containsKey(task)) {
                numbers = taskMap.get(task) + 1;
            } else {
                numbers = 1;
            }
            taskMap.put(task, numbers);
        }
        Collection<Integer> taskCollection = taskMap.values();
        // 倒序
        List<Integer> list = taskCollection.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        // 任务类别数量
        int taskTypeNumbers = list.size();
        // 任务种类 <= 一轮需要的任务数
        if (taskTypeNumbers <= n + 1) {
            int maxTaskNumber = list.get(0);
            times = maxTaskNumber * n;
            for (Integer i : list) {
                if (i < maxTaskNumber) {
                    break;
                }
                times++;
            }
            return times;
        }
        // 任务种类 > 1轮所需要的任务数
        int index = 0;
        while (list.get(0) > 0) {
            while (index <= n) {
                if (list.get(0) == 0) {
                    break;
                }
                if (index < 26 && list.get(index) > 0) {
                    list.add(list.get(index) - 1);
                }
                index++;
                times++;
            }
            // 重新倒序
            list.sort((o1, o2) -> o2 - o1);
            index = 0;
        }
        return times;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(solution.leastInterval(tasks, 1));
    }
}

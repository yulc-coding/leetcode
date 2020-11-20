package org.ylc.leetcode.p621;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // 存放每个任务
        Map<Character, Integer> taskMap = new HashMap<>();
        int numbers = 0;
        for (char task : tasks) {
            if (taskMap.containsKey(task)) {
                numbers += taskMap.get(task);
            } else {
                numbers = 1;
            }
            taskMap.put(task, numbers);
        }
        List<Integer> list = (List<Integer>) taskMap.values();
        list.sort(null);

        // 任务类别数量
        int taskNumbers = list.size();

        int defaultWaitNumbers = Math.max((n + 1 - taskNumbers), 0);
        
        return 0;
    }

}

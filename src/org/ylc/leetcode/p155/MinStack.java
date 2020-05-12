package org.ylc.leetcode.p155;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 155. 最小栈
 * 执行用时 : 6 ms, 在所有 Java 提交中击败了 98.07% 的用户
 * 内存消耗 : 41.8 MB, 在所有 Java 提交中击败了 13.25% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-05-12
 */
public class MinStack {

    /**
     * 数据
     */
    private List<Integer> array;

    /**
     * 每个栈顶对应的最小值
     */
    private List<Integer> minArray;

    /**
     * 栈元素个数
     */
    int stackSize;

    /**
     * 当前最小值
     */
    Integer min = null;

    public MinStack() {
        array = new ArrayList<>();
        minArray = new ArrayList<>();
        stackSize = 0;
    }

    /**
     * 将元素 x 推入栈中
     */
    public void push(int x) {
        // 计算最小值
        if (min == null) {
            min = x;
        } else {
            min = Math.min(min, x);
        }
        minArray.add(min);
        array.add(x);
        stackSize++;
    }

    /**
     * 删除栈顶的元素
     */
    public void pop() {
        array.remove(--stackSize);
        minArray.remove(stackSize);
        // 重置最小值
        if (stackSize == 0) {
            min = null;
        } else {
            min = minArray.get(stackSize - 1);
        }
    }

    /**
     * 获取栈顶元素
     */
    public int top() {
        return array.get(stackSize - 1);
    }

    /**
     * 检索栈中的最小元素
     */
    public int getMin() {
        return min == null ? 0 : min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        //minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}

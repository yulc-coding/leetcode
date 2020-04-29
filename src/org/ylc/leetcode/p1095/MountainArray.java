package org.ylc.leetcode.p1095;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 山脉数组
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/29
 */
public class MountainArray {

    private int[] array;

    public MountainArray(int[] array) {
        this.array = array;
    }

    public int get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }

}

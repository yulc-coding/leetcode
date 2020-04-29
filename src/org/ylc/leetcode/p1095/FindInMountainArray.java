package org.ylc.leetcode.p1095;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 1095. 山脉数组中查找目标值
 * 执行用时 : 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗 : 39.7 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/29
 */
public class FindInMountainArray {

    private int midIndex;

    private int curValue;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int first = 0;
        int last = mountainArr.length() - 1;

        int topIndex = findMountainTop(mountainArr, 0, last);

        int leftIndex = binarySearchLeft(mountainArr, target, first, topIndex);
        if (leftIndex != -1) {
            return leftIndex;
        }
        return binarySearchRight(mountainArr, target, topIndex + 1, last);
    }

    /**
     * 获取山顶索引
     */
    private int findMountainTop(MountainArray mountainArr, int first, int last) {
        while (first <= last) {
            midIndex = first + (last - first) / 2;
            if (mountainArr.get(midIndex) < mountainArr.get(midIndex + 1)) {
                first = midIndex + 1;
            } else {
                last = midIndex - 1;
            }
        }
        return first;
    }

    /**
     * 获取左边数组的目标索引，升序数组
     */
    private int binarySearchLeft(MountainArray mountainArr, int target, int first, int last) {
        while (first <= last) {
            midIndex = first + (last - first) / 2;
            curValue = mountainArr.get(midIndex);
            if (curValue == target) {
                return midIndex;
            }
            if (curValue < target) {
                first = midIndex + 1;
            } else {
                last = midIndex - 1;
            }
        }
        return -1;
    }

    /**
     * 获取右边数组的目标索引，降序数组
     */
    private int binarySearchRight(MountainArray mountainArr, int target, int first, int last) {
        while (first <= last) {
            midIndex = first + (last - first) / 2;
            curValue = mountainArr.get(midIndex);
            if (curValue == target) {
                return midIndex;
            }
            if (curValue < target) {
                last = midIndex - 1;
            } else {
                first = midIndex + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray(new int[]{0, 1, 2, 4, 2, 1});
        int target = 3;

        FindInMountainArray findInMountainArray = new FindInMountainArray();
        System.out.println(findInMountainArray.findInMountainArray(target, mountainArray));
    }
}

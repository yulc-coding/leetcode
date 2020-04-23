package org.ylc.leetcode.Interview.p08_11;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 面试题 08.11. 硬币
 * 数学排列组合
 * 执行用时 : 5 ms, 在所有 Java 提交中击败了 98.80% 的用户
 * 内存消耗 : 36.1 MB, 在所有 Java 提交中击败了 100.00% 的用户
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/4/23
 */
public class WaysToChange {

    public int run(int n) {

        int mod = 1000000007;
        long result = 0;
        // 25分最大个数
        int max25 = n / 25;
        // 10分最大个数
        int max10;
        // 余数
        int remainder;

        for (int i25 = max25; i25 >= 0; i25--) {
            remainder = n - 25 * i25;
            max10 = remainder / 10;
            /*
             * 每种10分的组合对应的个数为： 5分的个数 + 1（全部是1的情况）
             * 计算10分和5分的个数是一个等差数列求和
             * 每次少1个10分，5分的就多2个，即多2中组合
             * 10分最多 max10 个，最少0个
             * 对应的5分最少 （remainder - 10*max10）/5，最多为 remainder/5
             * 等差数列求和: (首项+末项)*项数/2：
             * (remainder/5 + 1  + (remainder - 10*max10)/5 +1) * (max10+1)/2
             */
            result = (result + (((long) ((remainder / 5 + 1 + (remainder - 10 * max10) / 5 + 1)) * (max10 + 1) / 2)) % mod) % mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
        System.out.println(waysToChange.run(900750));
    }
}

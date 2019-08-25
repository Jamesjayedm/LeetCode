package dynamicprogramming;
/* 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */

/* https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。
装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。

 */
public class LeetCode42 {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int sum = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];

        /*
        核心：动态规划思想，求出每一列左边和右边的最高点
         */
        for (int i = 1; i < height.length - 1; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }

        /*
        找到左边和右边较小的墙，然后和当前列比较一下
         */
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left_max[i], right_max[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;

    }
}

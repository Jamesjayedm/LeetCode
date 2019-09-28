package dpAndGreedy;
/* 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，所以你永远不可能到达最后一个位置。
 */

/*
https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
 */

public class LeetCode55 {
    /**
     * 1.动态规划
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 从后往前分析，依次判断是否可以到达当前位置，如果可以到达，就将状态位置为true
        /*if (nums == null)
            return false;
        boolean[] canJump = new boolean[nums.length];
        canJump[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int farthest = Math.min(i + nums[i], nums.length - 1);
            // 如果在这个范围内有可达的，就可以直接将i置为true，继续遍历上一个
            for (int j = i; j <= farthest; j++) {
                if (canJump[j]) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[0];*/

        // 从前往后遍历
        if (nums == null) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果之前的j节点可达，并且从此节点可以到跳到i
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];

    }

    /**
     * 2.贪心
     * 直接设定一个可达坐标，如果可以到达当前位置就将可达坐标更新为当前位置
     *
     * @param nums
     * @return
     */
    public boolean canJumpGreedy(int[] nums) {
        int lastCanJump = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastCanJump) {
                lastCanJump = i;
            }
        }
        return lastCanJump == 0;
    }
}

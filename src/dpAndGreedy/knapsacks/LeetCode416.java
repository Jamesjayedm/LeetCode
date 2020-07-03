package dpAndGreedy.knapsacks;

/* 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 */
public class LeetCode416 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i < len + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j]    // 不把nums[i]加入子集
                            || dp[i - 1][j - nums[i - 1]];  // 把nums[i]加入子集
                }
            }
        }

        return dp[len][sum];
    }

    public static void main(String[] args) {
        LeetCode416 l = new LeetCode416();
        int[] nums = {1, 5, 11, 5};
        System.out.println(l.canPartition(nums));
    }
}

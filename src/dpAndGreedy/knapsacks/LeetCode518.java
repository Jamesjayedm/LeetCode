package dpAndGreedy.knapsacks;

/* 零钱兑换（二）
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
示例 1:
输入: amount = 5, coins = [1, 2, 5]
输出: 4
解释: 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
链接：https://leetcode-cn.com/problems/coin-change-2
 */
public class LeetCode518 {
    public int change(int amount, int[] coins) {
        /*int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];    // dp[i][j] 使用前i个硬币，背包容量为j时，有dp[i][j]种方法装满背包
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] > j) {    // 当前硬币金额大于背包剩余容量，所以无法再放了
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j]    // 不放能凑成的种数
                            + dp[i][j - coins[i - 1]];   // 放入当前面额的金币
                }
            }
        }
        return dp[n][amount];*/

        // dp 数组的转移只和 dp[i][..] 和 dp[i-1][..] 有关，所以可以压缩成一维数组
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case
        for (int i = 0; i < n; i++)
            for (int j = 1; j <= amount; j++)
                if (j - coins[i] >= 0)
                    dp[j] = dp[j] + dp[j - coins[i]];
        return dp[amount];
    }
}

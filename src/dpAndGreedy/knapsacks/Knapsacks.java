package dpAndGreedy.knapsacks;

/*0-1背包问题

 */
public class Knapsacks {

    public static int knapsacks(int w, int n, int[] weights, int[] values) {
        // dp[i][j] 的定义如下：对于前 i 个物品，当前背包的容量为 j ，这种情况下可以装的最大价值是 dp[i][j]
        int[][] dp = new int[n + 1][w + 1];   // 最后要的结果是dp[n][w]
        dp[0][0] = dp[0][1] = dp[1][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],  // 不放入背包
                            dp[i - 1][j - weights[i - 1]] + values[i - 1]);   // 放入背包
                }
            }
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int w = 51;
        int n = val.length;
        System.out.println(knapsacks(w, n, wt, val));
    }
}

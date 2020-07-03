package 剑指offer.backtrace;

/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
示例 1：
输入：m = 2, n = 3, k = 1
输出：3
示例 2：
输入：m = 3, n = 1, k = 0
输出：1
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] dp = new boolean[m][n];
        return dfs(0, 0, m, n, k, dp);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] dp) {
        if (i >= m || j >= n || dp[i][j] || (sum(i) + sum(j)) > k) {     // 超过界限、已访问过的节点、数位和大于k的，都直接返回0
            return 0;
        }
        dp[i][j] = true;   // 标记当前单元格已访问
        return 1 + dfs(i + 1, j, m, n, k, dp) + dfs(i, j + 1, m, n, k, dp);   // 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数

    }

    private int sum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += index % 10;
            index /= 10;
        }
        return sum;
    }

}

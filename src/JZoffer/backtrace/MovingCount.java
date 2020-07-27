package JZoffer.backtrace;

import java.util.LinkedList;
import java.util.Queue;

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
    /**
     * DFS解法
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCountDFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || visited[i][j] || (sum(i) + sum(j)) > k) {     // 超过界限、已访问过的节点、数位和大于k的，都直接返回0
            return 0;
        }
        visited[i][j] = true;   // 标记当前单元格已访问
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);   // 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数
    }

    /**
     * BFS解法
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCountBFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0], j = temp[1];
            if (i >= m || j >= n || visited[i][j] || (sum(i) + sum(j)) > k)
                continue;             // 如果不成立，就跳过
            visited[i][j] = true;
            res++;
            queue.offer(new int[]{i + 1, j});   // 每次加入右边和下边的坐标元素
            queue.offer(new int[]{i, j + 1});
        }
        return res;
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

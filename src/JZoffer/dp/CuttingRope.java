package JZoffer.dp;

/*
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 */
public class CuttingRope {

    /**
     * 1.暴力解法 超时
     * 如果n - i比F(n - i)要大，显然就不用再继续分解了。故我们还需要比较i * (n - i)与i * F(n - i)的大小关系。所以完整的表达式应该为：
     * F(n)=max{i∗F(n−i), i∗(n−i)},i=1,2,...,n−1
     * 由于i和n - i的取值对称，i∗F(n−i) 和 F(i)∗(n−i)的取值集合是一样的，也就是说这两种情况算出来的结果是一样的，所以只取其中一种就可以了
     *
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cuttingRope1(n - i)));
        }
        return res;
    }

    /**
     * 2.记忆化搜索-自顶向下
     */

    public int cuttingRope2(int n) {
        int[] memory = new int[n + 1];
        return integerBreakHelper(n, memory);
    }

    public int integerBreakHelper(int n, int[] memory) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // memory的初始值为0，如果它不为0，说明已经计算过了，直接返回即可
        if (memory[n] != 0) {
            return memory[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res,    // 维持原状态，不剪
                    Math.max(i * integerBreakHelper(n - i, memory),   // 从i处剪一下 剩下的为n-i n-i继续剪
                            i * (n - i)));      // 从i处剪一下 剩下的为n-i n-i不剪了
        }
        // 将每次计算的结果保存到备忘录数组中
        memory[n] = res;
        return res;
    }

    /**
     * 3.动态规划-自底向上
     *
     * @param n
     * @return
     */
    public int cuttingRopeDP(int n) {
        int[] memory = new int[n + 1];
        memory[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memory[i] = Math.max(memory[i],     // 维持原状态，不剪
                        Math.max(j * memory[i - j], // 从j处剪一下 剩下的为i-j i-j继续剪
                                j * (i - j)));      // 从j处剪一下 剩下的为n-j n-j不剪了
            }
        }
        return memory[n];
    }

    /**
     * 4.贪心
     * 1会包含吗？ 不会，因为1 * (k - 1) < k, 只要把1和任何一个其他的片段组合在一起就有个更大的值
     * 2可以
     * 3可以
     * 4可以吗？ 它拆成两个2的效果和本身一样，因此也不考虑
     * 5以上可以吗？ 不可以，这些绳子必须拆，因为总有一种拆法比不拆更优，比如拆成 k / 2 和 k - k / 2
     * 综上, 最后的结果只包含2和3(当然当总长度为2和3时单独处理), 那么很显然n >= 5时， 3*(n - 3) >= 2 * (n - 2) ，
     * 因此我们优先拆成3，最后剩余的拆成2。最后的结果一定是由若干个3和1或2个2组成.
     *
     * @param n
     * @return
     */
    public int cuttingRopeGreedy(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return (int) (res * n);

    }

    public static void main(String[] args) {
        CuttingRope c = new CuttingRope();
        System.out.println(c.cuttingRopeGreedy(10));
    }


}

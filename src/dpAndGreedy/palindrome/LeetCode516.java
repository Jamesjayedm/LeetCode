package dpAndGreedy.palindrome;

/* 最长回文子序列
给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
示例 1:
输入:
"bbbab"
输出:
4
一个可能的最长回文子序列为 "bbbb"。
链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 */
public class LeetCode516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // 初始化，不可缺少
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 由于需要dp[i + 1][j], dp[i][j - 1],dp[i + 1][j - 1], 所以要从右下开始遍历，最后取右上角的值，即为s[i……j]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

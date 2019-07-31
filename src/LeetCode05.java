/* 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。*/

/*
中心扩展方法 从中间往两边判断，并分为奇数回文和偶数回文两种情况
 */
public class LeetCode05 {
    private int maxLen = 0;
    private int index = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length(); i++) {
            // 奇数回文串
            findPalindrome(s, i, i);
            // 偶数回文串
            findPalindrome(s, i, i + 1);
        }
        return s.substring(index, index + maxLen);
    }

    private int findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            maxLen = right - left - 1;
            index = left + 1;
        }
        return maxLen;
    }


/*
动态规划方法
P(i,j)=(P(i+1,j−1)&&S[i]==S[j])
 */

    public String longestPalindrome1(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}


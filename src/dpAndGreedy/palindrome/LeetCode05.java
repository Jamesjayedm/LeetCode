package dpAndGreedy.palindrome;/* 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。*/

/*
https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 */
public class LeetCode05 {
    private int maxLen = 0;
    private int index = 0;

    /*
    中心扩展方法 从中间往两边判断，并分为奇数回文和偶数回文两种情况
     */
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
        if (n < 2) {
            return s;
        }
        int start = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];

        // 可省略，因为不会取到对角线的值
        /*for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }*/
        for (int j = 1; j < n; j++) {   // 遍历的顺序非常重要，一定要保证左下角的值已经计算过[i + 1][j - 1]
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {     //j - i - 1 < 2 代表必为回文串
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        LeetCode05 l = new LeetCode05();
        System.out.println(l.longestPalindrome1(s));
    }
}


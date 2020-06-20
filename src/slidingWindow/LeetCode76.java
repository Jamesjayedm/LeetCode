package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/* 最小覆盖子串
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
示例：
输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：
如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
链接：https://leetcode-cn.com/problems/minimum-window-substring
 */

/*
滑动窗口模板
https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();    // 需要满足的字符
        Map<Character, Integer> window = new HashMap<>();  // 目前滑动窗口中的字符

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char c : tChars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;  // 记录最小覆盖子串的起始索引及长度
        while (right < sChars.length) {
            char c = s.charAt(right);
            // 右移窗口
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 左移窗口
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        LeetCode76 l = new LeetCode76();
        System.out.println(l.minWindow(s, t));
    }
}

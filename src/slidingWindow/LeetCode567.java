package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/* 字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
换句话说，第一个字符串的排列之一是第二个字符串的子串。
示例1:
输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
示例2:
输入: s1= "ab" s2 = "eidboaoo"
输出: False
注意：
输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
链接：https://leetcode-cn.com/problems/permutation-in-string
 */
public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();    // 需要满足的字符
        Map<Character, Integer> window = new HashMap<>();  // 目前滑动窗口中的字符

        char[] chars = s1.toCharArray();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            // 右移窗口
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).intValue() == window.get(c).intValue()) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            // 本题移动 left 缩小窗口的时机是窗口大小大于 s1.size() 时，因为排列的长度应该是⼀样的
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).intValue() == need.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        LeetCode567 l = new LeetCode567();
        System.out.println(l.checkInclusion(s1, s2));
    }

}

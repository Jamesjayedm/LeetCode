import java.util.HashSet;
import java.util.Set;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 :

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

        */
public class LeetCode03 {
    public static void main(String[] args) {
        LeetCode03 s = new LeetCode03();
        System.out.println(s.lengthOfLongestSubstring("abcbcaa"));
    }

    /*
    我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = i）中。
    然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。
    此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。如果我们对所有的 i 这样做，就可以得到答案。
    */
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        // 不在的话j往右滑
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                count = Math.max(count, j - i);
            } else {
                // 在的话i往右滑
                set.remove(s.charAt(i++));
            }
        }
        return count;
    }
}

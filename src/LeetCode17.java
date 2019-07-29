/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */

/*
回溯法：
如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了。
如果还有数字需要被输入：遍历下一个数字所对应的所有映射的字母。
将当前的字母添加到组合最后，也就是 s = s + letter 。 重复这个过程，输入剩下的数字

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    private Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backTrack(digits, 0, "");
        return result;
    }

    /**
     * 回溯函数
     *
     * @param digits 输入的字符
     * @param index  当前字符遍历的位置
     * @param s      产生好的一个组合
     */
    private void backTrack(String digits, int index, String s) {
        if (index == digits.length()) {
            // 若遍历到最后一个字符，则加入结果集
            result.add(s);
            return;
        }
        // 获取当前的数字对应的英文
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            // 循环对每一个字母进行遍历
            backTrack(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }

    public static void main(String[] args) {
        LeetCode17 l = new LeetCode17();
        System.out.println(l.letterCombinations("23"));
    }

}

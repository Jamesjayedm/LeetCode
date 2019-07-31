/* 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

 */

import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String str) {
        char[] ch = str.toCharArray();
        Stack<Character> s = new Stack<>();
        for (char c : ch) {
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                if (s.isEmpty()) {
                    return false;
                } else if (c == ')' && s.peek() == '(') {
                    s.pop();
                } else if (c == '}' && s.peek() == '{') {
                    s.pop();
                } else if (c == ']' && s.peek() == '[') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (!s.isEmpty()) {
            return false;
        }
        return true;
    }
}

package backTrace;
/* 括号生成
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

/* 回溯法
回溯算法基本思想：能进则进，进不了则换，换不了则退

括号生成算法类似于二叉树先序遍历
可用递归生成问题解空间树
再用剪枝函数来对解空间树进行剪枝
类似题目都可用回溯法。

 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        parenthesisBackTrace(result, n, n, "");
        return result;
    }

    public void parenthesisBackTrace(List<String> result, int left, int right, String temp) {
        // 判断是否"("个数小于")" 且"("或")"大于0，如果不是，则返回上一层
        if (left > right || left < 0 || right < 0)
            return;
        if (left == 0 && right == 0) {
            result.add(temp);
            return;
        }
        // 分别遍历左右子树
        parenthesisBackTrace(result, left - 1, right, temp + "(");
        parenthesisBackTrace(result, left, right - 1, temp + ")");

    }

    public static void main(String[] args) {
        LeetCode22 l = new LeetCode22();
        System.out.println(l.generateParenthesis(3));
    }
}

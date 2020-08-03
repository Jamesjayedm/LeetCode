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

https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    // 做减法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);    // 产生了一个新对象，所以无需回溯
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        LeetCode22 l = new LeetCode22();
        System.out.println(l.generateParenthesis(3));
    }
}

package backTrace;

import java.util.ArrayList;
import java.util.List;

/* 路径总和
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
链接：https://leetcode-cn.com/problems/path-sum-ii
 */

/*
二叉树的先序遍历+回溯（dfs）
 */
public class LeetCode113 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        backTrace(root, sum, path);
        return res;

    }

    private void backTrace(TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(path));   // 复制一个path，防止后续path的改变影响已经加入集合中的元素
        }
        backTrace(root.left, sum, path);
        backTrace(root.right, sum, path);
        path.remove(path.size() - 1);
    }
}

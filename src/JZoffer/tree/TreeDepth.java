package JZoffer.tree;

import java.util.LinkedList;
import java.util.Queue;

/* 二叉树的深度
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    // 递归写法
    /*public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }*/
    // 非递归写法,层次遍历
    public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode current = null;
        Queue<TreeNode> queue = new LinkedList<>();
        int cur = 0; // 记录当前遍历位置
        int width = 0; // 记录该层的节点数
        int depth = 0; // 记录深度
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = 0;
            width = queue.size();
            while (cur < width) {
                current = queue.poll();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
                cur++;
            }
            depth++;
        }
        return depth;
    }
}

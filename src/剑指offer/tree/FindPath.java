package 剑指offer.tree;

/* 二叉树中和为某一值的路径
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */

import java.util.ArrayList;

public class FindPath {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null)
            return res;
        find(root, target);
        return res;
    }

    private void find(TreeNode root, int target) {
        // System.out.println(res);
        // if (root == null)
        // return;
        path.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null)
            find(root.left, target - root.val);
        if (root.right != null)
            find(root.right, target - root.val);
        // 移除最后一个元素，深度遍历完一条路径后要回退到父节点
        path.remove(path.size() - 1);
        System.out.println(res);
    }

    public static void main(String[] args) {
        FindPath s = new FindPath();
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        s.findPath(t1, 22);
    }

}
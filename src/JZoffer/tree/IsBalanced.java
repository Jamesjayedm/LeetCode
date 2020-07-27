package JZoffer.tree;

/* 判断二叉树是否为平衡二叉树
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {
    // 普通写法,得到深度，再判定
    /*public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }*/

    // 剪枝做法，从下往上遍历，如果发现不是平衡的，直接返回
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

}

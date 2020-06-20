package 剑指offer.tree;

/* 二叉树的镜像
操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {

    public void mirror(TreeNode root) {
        TreeNode t;
        if (root != null) {
            t = root.left;
            root.left = root.right;
            root.right = t;
            if (root.left != null)
                mirror(root.left);
            if (root.right != null)
                mirror(root.right);
        }

    }
}

package 剑指offer.tree;

/* 判断二叉树子结构
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class HasSubtree {

    private boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean flag = false;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val == root2.val) {
            flag = isSubTree(root1, root2);
        }
        // 设置一个标志，如果两个值不相等，继续比较左子树和右子树与二叉树B
        if (!flag) {
            return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
        }
        return flag;
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else {
            return false;
        }

    }
}

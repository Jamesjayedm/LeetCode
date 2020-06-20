package 剑指offer.tree;

/* 前序中序重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
public class PreInToPostOrder {

    /**
     * 找到中序遍历序列的根节点，分别递归遍历左子树和右子树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= preEnd; i++) {
            if (in[i] == pre[preStart]) {
                // 先序遍历的左子树，即为preStart+1到循环中i移动的位置，就是preStart+i-inStart
                root.left = reConstructBinaryTree(pre, in, preStart + 1, preStart + (i - inStart), inStart, i - 1);
                // 先序遍历的右子树，即为左子树end+1（preStart+i-inStart+1）到preEnd。
                root.right = reConstructBinaryTree(pre, in, preStart + (i - inStart) + 1, preEnd, i + 1, inEnd);
                break;
            }
        }
        return root;
    }
}

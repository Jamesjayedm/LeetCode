package JZoffer.tree;

/* 二叉搜索树的第K个节点
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    int index = 0; //计数器

    TreeNode kthNode(TreeNode root, int k) {
        if (root != null) { //中序遍历寻找第k个
            TreeNode node = kthNode(root.left, k);
            if (node != null)
                return node;
            index++;
            if (index == k)
                return root;
            node = kthNode(root.right, k);
            if (node != null)
                return node;
        }
        return null;
    }

    //	          5
    //			/   \
    //		   3     7
    //		  / \   / \
    //		 2   4 6   8
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        KthNode s = new KthNode();
        s.kthNode(node1, 3);
    }
}

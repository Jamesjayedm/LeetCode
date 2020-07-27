package JZoffer.tree;

/* 二叉树转排序双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BSTConvertToLinkedList {
    // 双向链表的左边头结点和右边头节点
    private TreeNode leftHead = null;
    private TreeNode rightHead = null;

    /**
     * 中序遍历的运用
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        // 第一次运行时，它会使最左边叶子节点为链表第一个节点
        convert(pRootOfTree.left);
        if (rightHead == null) {
            leftHead = rightHead = pRootOfTree;
        } else {
            // 把根节点插入到双向链表右边，rightHead向后移动
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead; // 构造双向链表
            rightHead = pRootOfTree;
        }
        // 把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
        convert(pRootOfTree.right);
        // 返回左边头结点
        return leftHead;
    }

    public static void main(String[] args) {
        BSTConvertToLinkedList bstConvert = new BSTConvertToLinkedList();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        bstConvert.convert(t1);
    }
}

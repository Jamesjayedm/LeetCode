package JZoffer.tree;

/*二叉树的序列化和反序列化
二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class Serialize {

    public int index = -1;

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // 错误做法，这样的话每次的sb都记录了上一次调用的信息，把所有的放进sb中了。
    //	StringBuffer sb = new StringBuffer();
    //
    //	public String Serialize(TreeNode root) {
    //		if (root == null) {
    //			sb.append("*,");
    //			return sb.toString();
    //		}
    //		sb.append(root.val + ",");
    //		sb.append(Serialize(root.left));
    //		sb.append(Serialize(root.right));
    //		return sb.toString();
    //	}

    public TreeNode deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }

        return node;
    }

    public static void main(String[] args) {
        //			  5
        //			 / \
        //			2   3
        //		   /   / \
        //		  1   7   6
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        Serialize s = new Serialize();
        String str = s.serialize(node1);
        System.out.println(str);
        System.out.println(s.deserialize(str));
    }
}

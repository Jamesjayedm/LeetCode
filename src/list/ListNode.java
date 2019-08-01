package list;

/*
  链表数据结构
 */
public class ListNode {
    // Definition for singly-linked list.
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void printListNode(ListNode listNode) {
        for (ListNode node = listNode; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }
    }
}

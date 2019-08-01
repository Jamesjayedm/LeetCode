package list;

/* 反转链表
反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 */


public class LeetCode206 {
    /*
    1.迭代
     */
    /*public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 注意 不能写成如下代码 否则第一次1->2的链还没断的时候，就变成2->1，造成无限循环。
//        ListNode previous = head;
//        ListNode current = head.next;

        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;

    }*/

    /*
    2.递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        LeetCode206 l = new LeetCode206();
        ListNode.printListNode(l.reverseList(n1));
    }
}

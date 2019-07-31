/* 合并k个排序链表
合并k个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        return merge(0, lists.length - 1, lists);
    }

    private ListNode merge(int start, int end, ListNode[] lists) {
        if (start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        ListNode listNode1 = merge(start, mid, lists);
        ListNode listNode2 = merge(mid + 1, end, lists);
        return mergeList(listNode1, listNode2);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        LeetCode23 l = new LeetCode23();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        n7.next = n8;
        // 1->4->5,
        // 1->3->4,
        // 2->6
        ListNode[] listNodes = {n1, n4, n7};
        l.mergeKLists(listNodes);
    }

}

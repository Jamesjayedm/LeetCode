package list;
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

import java.util.PriorityQueue;


public class LeetCode23 {
    /*
    1.分治
    思路：
    代码结构和“归并排序”可以说是同出一辙：

    1）先一分为二，分别“递归地”解决了与原问题同结构，但规模更小的两个子问题；

    2）再考虑如何合并，这个合并的过程也是一个递归方法（同 LeetCode 第 21 题：合并两个有序链表）。

     */

    /*public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        return merge(0, lists.length - 1, lists);
    }

    private ListNode merge(int start, int end, ListNode[] lists) {
        // 根据递归调用情况，区间最窄的时候，只可能是左右端点重合
        if (start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        ListNode listNode1 = merge(start, mid, lists);
        ListNode listNode2 = merge(mid + 1, end, lists);
        return mergeTwoList(listNode1, listNode2);
    }

    // 合并两个链表 见LeetCode21
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }

    }*/


    /*
    2.优先级队列、贪心算法
    思路：
    用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空

     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) return -1;
            else if (o1.val == o2.val) return 0;
            else return 1;
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            // 将K个链表按头节点的大小顺序加入优先级队列中
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            // 当前新构造链表的next指针指向出队元素
            p.next = queue.poll();
            // 当前指针向后移动一个元素，指向刚刚出队的元素
            p = p.next;
            // 若非空，将刚刚出队的元素的下一个元素，继续添加到优先级队列中
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
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

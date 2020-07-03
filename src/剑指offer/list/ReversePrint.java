package 剑指offer.list;

import java.util.ArrayList;
import java.util.List;

/* 从头到尾打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private List<Integer> list = new ArrayList<>();

    public int[] reversePrintRecursive(ListNode head) {
        recursive(head);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void recursive(ListNode node) {
        if (node == null)
            return;
        recursive(node.next);
        list.add(node.val);
    }
}
package 链表.单链表删除数字_203;

import 链表.structure.ListNode;

//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1), p = dummy, cur = head;
        dummy.next = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
                p.next = next;
                cur = next;
            } else {
                p = cur;
                cur = next;
            }
        }

        return dummy.next;
    }

}

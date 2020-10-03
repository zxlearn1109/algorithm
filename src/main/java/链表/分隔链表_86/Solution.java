package 链表.分隔链表_86;

import 链表.structure.ListNode;

//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。
//
//
//
// 示例:
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
//
// Related Topics 链表 双指针
// 👍 264 👎 0
public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1), pre = dummy, cur = head;
        dummy.next = head;
        ListNode lessDummy = new ListNode(-1), q = lessDummy;

        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                q.next = cur;
                q = q.next;
            } else
                pre = cur;
            cur = cur.next;
        }
        q.next = dummy.next;

        return lessDummy.next;
    }

    //思路:分离出一个小值链表，原链表为大值链表
}

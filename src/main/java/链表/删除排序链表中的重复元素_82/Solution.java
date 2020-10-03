package 链表.删除排序链表中的重复元素_82;

import 链表.structure.ListNode;

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表
// 👍 375 👎 0
public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1), pre = dummy, cur = head;
        dummy.next = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                pre.next = cur.next;
            }else
                pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

}

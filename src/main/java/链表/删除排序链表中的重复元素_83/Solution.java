package 链表.删除排序链表中的重复元素_83;

import 链表.structure.ListNode;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 405 👎 0
public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1), pre = dummy, cur = head;
        dummy.next = head;
        while (cur != null) {
            boolean dup = cur.next != null && cur.val == cur.next.val;
            if (dup){
                while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
                pre.next = cur;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

}

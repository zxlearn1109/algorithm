package 链表.单链表排序_148;

import 链表.structure.ListNode;

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
// 示例 1:
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2:
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
public class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);

        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {

        if (left == null) return right;
        if (right == null) return left;

        ListNode dummy = new ListNode(-1), p = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }

        if (left != null) p.next = left;
        if (right != null) p.next = right;
        return dummy.next;
    }

}

//链表归并排序
//归并排序的思想是分治，将左边先进性排序，然后将右边进行排序，最后将左右合并排序
//与数组的区别在于，数组可以通过索引卡边界，链表只能通过快慢指针划分，并将相邻节点的next指针设置为null即可

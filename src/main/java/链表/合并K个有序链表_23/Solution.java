package 链表.合并K个有序链表_23;

import 链表.structure.ListNode;

public class Solution {

    //k个链表  Time:O(k * n) Space:O(1)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) return null;
        ListNode node = null;
        for (int i = 0; i < lists.length; i++) {
            node = mergeListNode(node, lists[i]);
        }
        return node;
    }

    //k个链表  Time:O(n * logk) Space:O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {

        if (start > end) return null;
        if (start == end) return lists[start];

        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeListNode(left, right);
    }

    public ListNode mergeListNode(ListNode left, ListNode right) {
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

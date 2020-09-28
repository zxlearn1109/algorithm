package 链表.判断单链表是否有环_141;

import 链表.structure.ListNode;

public class Solution {

    //Time:O(n)     Space:O(1)
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    //思路
    //判断链表是否有环，采取快慢指针法，慢指针走一步，快指针走两步。
    // 如果链表有环的话，等价于慢指针原地不动，快指针走一步，总有一天会相遇
}

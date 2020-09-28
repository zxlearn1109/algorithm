package 链表.单链表插入排序_147;

import 链表.structure.ListNode;

public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode q = head;

        while (q != null) {
            if (p.next != null && p.next.val > q.val) p = dummy;
            while (p.next != null && p.next.val <= q.val) p = p.next;

            ListNode next = p.next;
            p.next = q;
            q = q.next;
            p.next.next = next;
        }
        return dummy.next;
    }

}

//思路
//插入排序思路：新建链表，以哑元节点dummy作为头，p作为移动指针，取原链表上的节点q加入以dummy为头结点的链表中
//p.next != null && p.next.val <= q.val  比较p.next和q，小于的话不断右移。否则的话，将q加入p和p.next之间，q后移
// if (p.next != null && p.next.val > q.val) p = dummy;
// if条件为加速过程，并不是每次p都需要从头开始，只有当p下一个节点大于q的值时，p才需要从头开始
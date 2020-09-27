package 链表.两两交换链表中的节点_24;

import 链表.structure.ListNode;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
public class Solution {

    //Time:O(n)    Space:O(1)
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1), pre = dummy, cur = head, next = head.next;
        dummy.next = cur;

        while (cur != null && next != null) {
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
            if (cur != null) next = cur.next;
        }

        return dummy.next;
    }

    //思路：1->2->3->4->5两两交换，以段3，4举例，需要将2的next指针指向4,3的next指向5,4的next指向3
    //将节点3看为cur节点，节点4看为next节点，因为需要更改cur节点之前的引用，故名为pre，这里引入dummy节点更好处理表头。

}

package 链表.求两个单链表之和_2;

import 链表.structure.ListNode;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 4993 👎 0
public class Solution {

    //Time:O(n)     Space:O(1)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1), p = dummy;
        boolean up = false;
        while (l1 != null || l2 != null) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (up ? 1 : 0);
            p.next = new ListNode(val % 10);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            up = val >= 10;
        }
        if (up) p.next = new ListNode(1);
        return dummy.next;

    }

    //引入哑元节点，短链表用0展示，当前值可用两个链表的值+是否进位？1：0
}

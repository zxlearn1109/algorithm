package 链表.合并两个有序链表_21;

import 链表.structure.ListNode;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1290 👎 0
public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1), p = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        return dummy.next;
    }

    //思路:起一个dummy节点，p指针指向，比较两条链表大小，续接到p上，移动p指针，直至两条链表都为空
}

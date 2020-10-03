package 链表.删除链表的倒数第N个节点_19;

import 链表.structure.ListNode;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针
// 👍 1010 👎 0
public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1), slow = dummy, fast = dummy;
        dummy.next = head;

        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode pre = slow,cur = slow.next;
        pre.next = cur.next;
        return dummy.next;
    }

    //思路:增加哑元节点dummy，快指针先走n步，然后快慢指针每次各走一步直至快指针走到结尾。
    //移除慢指针的下一个节点，返回链表头部
}

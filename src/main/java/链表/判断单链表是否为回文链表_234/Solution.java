package 链表.判断单链表是否为回文链表_234;
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

import 链表.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //Time:O(n)     Space:O(n)
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;

        List<ListNode> nodeList = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) nodeList.add(node);

        int start = 0, end = nodeList.size() - 1;

        while (start <= end) {
            if (nodeList.get(start++).val != nodeList.get(end--).val) return false;
        }
        return true;
    }
    //思路:遍历链表，用集合储存链表中所有节点。然后用双指针从集合两侧向中间靠拢比较节点值，若不等返回false，否则遍历结束返回true

    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode leftHead = head, rightHead = null;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        rightHead = slow.next;
        slow.next = null;
        boolean odd = fast == null;

        rightHead = reverseListNode(rightHead);

        while (leftHead != null && rightHead != null) {
            if (leftHead.val != rightHead.val) return false;
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }

        if (odd) return leftHead.next == null && rightHead == null;

        return leftHead == null && rightHead == null;
    }

    //思路：回文链表写起来还蛮繁琐的...
    //首先用快慢指针将链表分成2份，根据快指针判断链表总长度是奇数还是偶数
    //将右链表整体反转
    //对比左右链表，都不为空若有一个值不相等则不是回文链表。否则进入到至少有一个为空的情况
    //链表长度为奇数：左链表还有一个节点，右链表为空。   链表长度为偶数:左链表和右链表都为空

    private static ListNode reverseListNode(ListNode rightHead) {

        if (rightHead == null || rightHead.next == null) return rightHead;
        ListNode pre = null, cur = rightHead;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null) next = cur.next;
        }

        return pre;
    }

}

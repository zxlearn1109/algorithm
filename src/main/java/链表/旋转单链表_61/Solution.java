package 链表.旋转单链表_61;
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针
// 👍 338 👎 0

import 链表.structure.ListNode;

public class Solution {

    //Time:O(n)     Space:O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null|| k< 0)return head;

        int len = 0;
        for (ListNode p = head; p != null; len++, p = p.next);

        k %= len;
        if(k == 0) return head;
        int move = len - k - 1;
        ListNode end = head;
        for (int i = 0; i < move; i++) {
            end = end.next;
        }

        ListNode newHead = end.next,newEnd = newHead;
        end.next = null;

        while(newEnd.next != null) newEnd = newEnd.next;

        newEnd.next = head;
        return newHead;
    }

    //思路:选装链表k个节点，就是将右边的链表放在链表头部。
    //第一步求原链表长度h，k对h取余。k>h，我们可以对其缩小
    //找到前一部分的尾节点，获取新的头结点。前一部分尾节点的next指针设为null
    //获取右边链表的尾节点，指向头指针，返回新的头指针即可

}

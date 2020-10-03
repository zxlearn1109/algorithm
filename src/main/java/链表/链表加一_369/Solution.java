package 链表.链表加一_369;

import 链表.structure.ListNode;
//用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
//
// 你可以假设这个整数除了 0 本身，没有任何前导的 0。
//
// 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//
// Related Topics 链表
// 👍 45 👎 0
public class Solution {

    //Time:O(n)      Space:O(1)
    public ListNode plusOne(ListNode head) {

        ListNode dummy = new ListNode(-1),notNine = dummy;
        dummy.next = head;

        for(ListNode node = head;node != null ;node = node.next){
            if (node.val != 9) notNine = node;
        }

        notNine.val = notNine.val + 1;
        for (ListNode node = notNine.next;node != null;node = node.next) node.val = 0;

        return dummy == notNine ? dummy : dummy.next;
    }

    //思路:寻找最后一个不为9的数字进行加1，，其后的所有数字都设置为0。
    // 引入dummy节点，如果dummy节点和最后一个不为9是同一个节点，则直接返回dummy节点否则返回dummy的next节点
}

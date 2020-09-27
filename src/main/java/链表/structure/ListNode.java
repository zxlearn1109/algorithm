package 链表.structure;

import lombok.Getter;

@Getter
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

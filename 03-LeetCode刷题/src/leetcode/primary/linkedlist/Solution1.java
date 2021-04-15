package leetcode.primary.linkedlist;




class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution1 {

    public void deleteNode(ListNode node) {
        int nextVal = node.next.val;
        node.val = nextVal;
        node.next = node.next.next;
    }
}

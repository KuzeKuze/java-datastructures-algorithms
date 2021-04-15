package leetcode.primary.linkedlist;

public class Solution6 {

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        while( p != null) {
            if (p.val == Integer.MAX_VALUE) {
                return true;
            }
            p.val = Integer.MAX_VALUE;
            p = p.next;
        }
        return false;
    }
}

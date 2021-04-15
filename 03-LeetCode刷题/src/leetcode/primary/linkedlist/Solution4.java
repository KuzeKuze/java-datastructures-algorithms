package leetcode.primary.linkedlist;
//https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/

public class Solution4 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode p = head;

        while (p1 != null && p2 != null){
            if( p1.val < p2.val){
                p.next = p1;
                p = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }
        while( p1 != null ){
            p.next = p1;
            p = p1;
            p1 = p1.next;
        }
        while( p2 != null ){
            p.next = p2;
            p = p2;
            p2 = p2.next;
        }

        return head.next;

    }
}

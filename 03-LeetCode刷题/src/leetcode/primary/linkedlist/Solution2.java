package leetcode.primary.linkedlist;
// https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/

import java.util.Stack;
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        ListNode pre = stack.pop();
        ListNode newHead = pre;
        while(!stack.empty()){
            p = stack.pop();
            pre.next = p;
            pre = p;
        }
        pre.next = null;

        return newHead;
    }

    // 一个节点一个节点的摘掉
    public ListNode reverseList2(ListNode head) {
        ListNode tmp;
        ListNode newHead = null;
        while(head != null){
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode reverse = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }


}

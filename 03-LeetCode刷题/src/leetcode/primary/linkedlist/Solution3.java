package leetcode.primary.linkedlist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 */
public class Solution3 {

    /**
     * 用栈反转
     */
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





}

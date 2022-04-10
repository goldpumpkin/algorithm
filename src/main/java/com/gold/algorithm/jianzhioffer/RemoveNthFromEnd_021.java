package com.gold.algorithm.jianzhioffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/SLwz0R/submissions/
 * 还有一种方法：快慢指针，想不到就去看评论
 */
public class RemoveNthFromEnd_021 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode c = head;
        Stack<ListNode> s = new Stack<>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }

        int i = 1;
        while (true) {
            final ListNode pop = s.pop();
            if (i == n) {
                final ListNode next = pop.next;
                if (s.isEmpty()) {
                    c = next;
                } else {
                    final ListNode pre = s.pop();
                    pre.next = next;
                }
                break;
            }
            i++;
        }

        return c;
    }

    /**
     * 尝试使用一遍扫描
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        final Map<Integer, ListNode> allNode = new HashMap<>();
        int count = 0;
        while (head != null) {
            count++;
            allNode.put(count, head);
            head = head.next;
        }

        int removeNodeVal = count - n + 1;
        int removeNodePre = count - n;

        ListNode remove = allNode.get(removeNodeVal);
        ListNode pre = allNode.get(removeNodePre);

        final ListNode next = remove.next;
        if (pre == null) {
            return next;
        } else {
            pre.next = next;
        }

        return allNode.get(1);
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

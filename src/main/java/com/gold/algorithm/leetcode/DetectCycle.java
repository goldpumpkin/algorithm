package com.gold.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 检测环，并找到环点
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/submissions/
 */
public class DetectCycle {

    /**
     * 核心思路：标记已经走过的node，判断后面的节点时候和已经走过的节点相同
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> s = new HashSet<>();
        while (head.next != null) {
            s.add(head);

            if (s.contains(head.next.next)) {
                return head.next.next;
            }

            head = head.next;
        }


        return null;
    }

    /**
     * 核心思路：快慢指针。有环必相遇；相遇后引入新变量
     * 理解点：
     * 1. 有环是不是一定会相遇
     * 2. 凭借快慢指针速度的关系，得到 head 到环起点的等式
     * 3. 理解等式的含义，分别以相遇点和head开始，假设以相同的速度，想象一下过程
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
            slow = slow.next;
        }

        if (fast != slow) {
            return null;
        }

        ListNode posNode = head;
        while (posNode != slow) {
            posNode = posNode.next;
            slow = slow.next;
        }

        return posNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

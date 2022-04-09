package com.gold.algorithm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListNode<T> {

    private T data;

    private ListNode<T> next;

    public static ListNode<String> buildPalindrome() {
        final String s = "rr";
        return buildSinglyLinkedList(s);
    }

    public static ListNode<String> buildSinglyLinkedList(String s) {
        final char[] chars = s.toCharArray();

        ListNode<String> head = null;
        ListNode<String> prev = null;
        for (char c : chars) {
            final String d = Character.valueOf(c).toString();
            final ListNode<String> node = ListNode.<String>builder()
                .data(d)
                .build();

            if (prev == null) {
                head = prev = node;
                continue;
            }

            prev.setNext(node);
            prev = node;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode<String> stringListNode = buildPalindrome();
        System.out.println(stringListNode);
    }

    @Override
    public String toString() {
        final StringBuilder s = new StringBuilder();
        ListNode<String> head = (ListNode<String>) this;
        while (head != null) {
            s.append(head.getData());
            head = head.next;
        }

        return s.toString();
    }
}

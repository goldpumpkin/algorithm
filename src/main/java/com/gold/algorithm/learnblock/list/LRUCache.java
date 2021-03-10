package com.gold.algorithm.learnblock.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author goldhuang
 * @Description: 线程不安全缓存 淘汰策略LRU
 * @date 2021-03-10
 */
public class LRUCache {


    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    /**
     * 添加结点
     *
     * @param data
     */
    public void add(Object data) {
        if (head == null) {
            this.head = Node.builder()
                .data(data)
                .next(null)
                .build();
            this.tail = this.head;
            size++;
            return;
        }

        // remove last node
        if (this.size + 1 > capacity) {
            Node current = this.head;
            while (current.next != null) {
                if (Objects.equals(this.tail, current.next)) {
                    current.next = null;
                    this.tail = current;
                    size--;
                    break;
                }
                current = current.next;
            }
        }

        this.head = Node.builder()
            .data(data)
            .next(head)
            .build();

        size++;
    }

    public Node get(Object value) {
        Node current = head;
        Node target = null;
        Node pre = null;
        while (current != null) {
            if (Objects.equals(current.data, value)) {
                target = current;
                if (pre != null) {
                    pre.next = target.next;
                }
                target.next = this.head;
                this.head = target;
            }
            pre = current;
            current = current.next;
        }

        return target;
    }

    public int size() {
        return this.size;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node {
        private Object data;
        private Node next;
    }

}

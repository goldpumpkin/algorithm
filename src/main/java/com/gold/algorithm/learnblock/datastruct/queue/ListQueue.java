package com.gold.algorithm.learnblock.datastruct.queue;

import com.gold.algorithm.learnblock.list.Node;

/**
 * @author goldhuang
 * @Description: 链式队列
 * @date 2021-03-15
 */
public class ListQueue {

    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public ListQueue(int capacity) {
        this.capacity = capacity;
        this.head = this.tail = new Node();
        this.size = 0;
    }

    public boolean enqueue(Object o) {
        if (size == capacity) {
            return false;
        }

        tail.setNext(new Node(o));
        tail = tail.getNext();
        size++;
        return true;
    }

    public Object dequeue() {
        if (head == tail) {
            return null;
        }

        Node next = head.getNext();
        Object result = next.getData();
        head.setNext(next.getNext());
        size--;

        // 复位
        if (tail == next) {
            tail = head;
        }
        return result;
    }
}

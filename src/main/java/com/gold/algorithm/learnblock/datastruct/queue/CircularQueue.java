package com.gold.algorithm.learnblock.datastruct.queue;

/**
 * @author goldhuang
 * @Description: 循环队列
 * @date 2021-03-15
 */
public class CircularQueue {

    private Object[] data;
    private int head;
    private int tail;
    private int capacity;
    private int size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean enqueue(Object o) {
        if (size == capacity) {
            return false;
        }

        data[tail] = o;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public Object dequeue() {
        if (size == 0) {
            return null;
        }

        Object result = data[head];
        head = (head + 1) % capacity;
        size--;
        return result;
    }

    public int size() {
        return this.size;
    }
}

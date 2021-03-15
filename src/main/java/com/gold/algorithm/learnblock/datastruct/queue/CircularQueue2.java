package com.gold.algorithm.learnblock.datastruct.queue;

/**
 * @author goldhuang
 * @Description: 循环队列
 * @date 2021-03-15
 */
public class CircularQueue2 {

    private Object[] data;
    private int head;
    private int tail;
    private int capacity;

    public CircularQueue2(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(Object o) {
        if ((tail + 1) % capacity == head) {
            return false;
        }

        data[tail] = o;
        tail = (tail + 1) % capacity;
        return true;
    }

    public Object dequeue() {
        if (head == tail) {
            return null;
        }

        Object result = data[head];
        head = (head + 1) % capacity;
        return result;
    }

    public int size() {
        return tail < head ? (tail + capacity) - head : tail - head;
    }
}

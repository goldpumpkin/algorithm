package com.gold.algorithm.learnblock.datastruct.queue;

/**
 * @author goldhuang
 * @Description: 顺序队列
 * @date 2021-03-15
 */
public class ArrayQueue {

    private Object[] data;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    public boolean enqueue(Object o) {
        if (tail == capacity) {
            // 整个队列都满了
            if (head == 0) {
                return false;
            }

            // 迁移数据
            for (int i = head; i < tail; i++) {
                data[i - head] = data[i];
            }
            tail -= head;
            head = 0;
        }

        data[tail++] = o;
        return true;
    }

    public Object dequeue() {
        if (head == tail) {
            return null;
        }

        Object o = data[head++];
        return o;
    }
}

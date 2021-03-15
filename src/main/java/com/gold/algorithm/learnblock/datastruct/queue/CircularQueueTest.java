package com.gold.algorithm.learnblock.datastruct.queue;

/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-15
 */
public class CircularQueueTest {

    /**
     * 对比这两种可以发现，第一种，可以数组的占满，第二种不可以。
     * 区别在于，对队满和队空的判断标准
     */
    public static void main(String[] args) {
        testCircularQueue();

        System.out.println("----------------------------------------------------");

        testCircularQueue2();
    }

    public static void testCircularQueue() {
        int capacity = 2;
        CircularQueue circularQueue = new CircularQueue(2);
        System.out.println("circularQueue capacity:" + capacity);
        System.out.println("circularQueue enqueue 1, result: " + circularQueue.enqueue("1"));
        System.out.println("circularQueue enqueue 2, result: " + circularQueue.enqueue("2"));
        System.out.println("circularQueue size:" + circularQueue.size());

        System.out.println("circularQueue enqueue 3, result: " + circularQueue.enqueue("3"));
        System.out.println("circularQueue dequeue, result: " + circularQueue.dequeue());

        System.out.println("circularQueue enqueue 4, result: " + circularQueue.enqueue("4"));
        System.out.println("circularQueue dequeue, result: " + circularQueue.dequeue());
        System.out.println("circularQueue dequeue, result: " + circularQueue.dequeue());
        System.out.println("circularQueue dequeue, result: " + circularQueue.dequeue());
    }

    public static void testCircularQueue2() {
        int capacity = 2;
        CircularQueue2 circularQueue = new CircularQueue2(2);
        System.out.println("circularQueue2 capacity:" + capacity);
        System.out.println("circularQueue2 enqueue 1, result: " + circularQueue.enqueue("1"));
        System.out.println("circularQueue2 enqueue 2, result: " + circularQueue.enqueue("2"));
        System.out.println("circularQueue2 size:" + circularQueue.size());

        System.out.println("circularQueue2 enqueue 3, result: " + circularQueue.enqueue("3"));
        System.out.println("circularQueue2 dequeue, result: " + circularQueue.dequeue());

        System.out.println("circularQueue2 enqueue 4, result: " + circularQueue.enqueue("4"));
        System.out.println("circularQueue2 dequeue, result: " + circularQueue.dequeue());
        System.out.println("circularQueue2 dequeue, result: " + circularQueue.dequeue());
        System.out.println("circularQueue2 dequeue, result: " + circularQueue.dequeue());
    }

}

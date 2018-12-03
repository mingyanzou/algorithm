package com.zmy.basic.queue;

public class CircularQueue {
    private int[] items;
    private int n;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        items = new int[capacity];
        n = capacity;
    }

    public boolean enqueuq(int value) {
        if ((tail + 1) % n == head) return false;
        items[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    public int dequeue() {
        if (head == tail) return -1;
        int value = items[head];
        head = (head + 1) % n;
        return value;
    }

    public void printAll() {
        if (n == 0) return;
        for (int i = head; i % n != tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

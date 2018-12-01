package com.zmy.basic.queue;

public class DynamicArrayQueue {

    private int[] items;
    private int count;
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        items = new int[capacity];
        count = capacity;
    }

    public boolean enqueue(int value) {
        if (tail == count) {
            if (head == 0) return false;
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }
        items[tail] = value;
        ++tail;
        return true;
    }

    public int dequeue() {
        if (head == tail) return -1;
        int value = items[head];
        ++head;
        return value;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
             System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

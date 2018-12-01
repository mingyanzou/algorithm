package com.zmy.basic.queue;

public class ArrayQueue {

    private int[] items;
    private int n;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int count) {
        items = new int[count];
        n = count;
    }

    public boolean enqueue(int value) {
        if (tail == n) return false; //queue已经满了
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

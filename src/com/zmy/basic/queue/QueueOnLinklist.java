package com.zmy.basic.queue;

/**
 *  基于int类型链表实现的queue
 */
public class QueueOnLinklist {
    private Node head;
    private Node tail;

    public void enqueue(int value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    public int dequeue() {
        if (head == null) return -1;
        int value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node q = head;
        while (q != null) {
            System.out.print(q.data + " ");
            q = q.next;
        }
        System.out.println();
    }

    public class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}

package com.zmy.basic.stack;

import javax.xml.stream.events.NotationDeclaration;

public class StackOnLinkedList {
    Node top;

    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) return -1;
        int data = top.data;
        top = top.next;
        return data;
    }

    public void printAll() {
        Node q = top;
        while (q != null) {
            System.out.print(q.data + " ");
            q = q.next;
        }
        System.out.println();
    }

    public class Node {
        private int data;
        private Node next;

        public Node(int value, Node next) {
            data = value;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}

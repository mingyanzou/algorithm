package com.zmy.basic;

import java.nio.file.NotDirectoryException;

public class LinkedListAlgo {


    /**
     * 单链表反转
     */
    public static Node reverseLinkedList(Node node) {
        Node head = null;
        Node previous = null;
        Node current = node;
        while (current != null) {
            Node nextNode = current.next;
            if (nextNode == null) {
                head = current;
            }
            current.next = previous; //实现反转
            previous = current; // 记录和移动previous
            current = nextNode; // 移动head
        }

        return head;
    }

    /**
     * 检查环
     */
    public static boolean checkCircle(Node node) {
        if (node == null) return false;
        Node fast = node.next;
        Node slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }
        return false;
    }


    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
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

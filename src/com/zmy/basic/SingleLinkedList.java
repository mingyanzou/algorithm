package com.zmy.basic;


/**
 * 单链表
 * 数据存储为int类型
 */
public class SingleLinkedList {
    private Node head;


    public void insertHead(int value) {
        Node newNode = new Node(value, null);
        insertHead(newNode);
    }

    public void insertHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertHead(newNode);
            return;
        }

        Node q = head;
        while (q.next != null) {
            q = q.next;
        }
        q.next = newNode;
        newNode.next = p;
    }

    public Node findNodeByValue(int value) {
        Node q = head;
        while (q != null && q.data != value) {
            q = q.next;
        }
        return q;
    }

    public Node findNodeByIndex(int index) {
        Node q = head;
        int pos = 0;
        while (q != null && pos != index) {
            q = q.next;
            ++pos;
        }
        return q;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        if (p == head) {
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;

        }
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;
        //注意极端情况，只有Head...
        Node q = head;
        Node p = null;
        while (q != null && q.data != value) {
            p = q;
            q = q.next;
        }
        if (p == null) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }

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

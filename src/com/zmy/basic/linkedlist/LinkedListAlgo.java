package com.zmy.basic.linkedlist;

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

    /**
     * 有序合并连个单链表
     *
     * @param la
     * @param lb
     * @return
     */
    public static Node mergeSortList(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;
        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;
        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (q != null) {
            r.next = q;
        } else {
            r.next = p;
        }
        return head;
    }

    public static Node selectMiddleNode(Node a) {
        if (a == null) return null;
        Node fast = a;
        Node slow = a;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node deleteLastNthNode(Node list, int n) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < n) {
            fast = fast.next;
            ++i;
        }
        if (fast == null) return list;

        Node slow = list;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }

    public static Node deleteLastNth2(Node list, int n) {
        Node curNode = list;
        Node slowNode = list;
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        //删如果是头结点
        if (curNode == null) {
            list = list.next;
            return list;
        }

        while (curNode.next != null) {
            curNode = curNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return list;
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

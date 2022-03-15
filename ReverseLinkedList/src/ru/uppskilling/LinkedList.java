package ru.uppskilling;

public class LinkedList {

    public Node head;

    static class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
            next = null;
        }
    }

    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null)
            return head;
        Node tmp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

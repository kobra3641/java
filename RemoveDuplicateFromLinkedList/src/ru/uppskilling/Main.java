package ru.uppskilling;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        ListNode headA = ListNode.create(1);
        headA.next = ListNode.create(1);
        headA.next.next = ListNode.create(2);
        headA.next.next.next = ListNode.create(2);
        headA.next.next.next.next = ListNode.create(3);
        headA.next.next.next.next.next = ListNode.create(3);
        headA.next.next.next.next.next.next = ListNode.create(4);
        headA.next.next.next.next.next.next.next = ListNode.create(4);
        ListNode.printLinkedList(headA);
        ListNode.deleteDuplicates(headA);
        ListNode.printLinkedList(headA);
    }

    static class ListNode {
        int data;
        ListNode next;

        static ListNode create(int data) {
            ListNode tmp = new ListNode();
            tmp.data = data;
            tmp.next = null;
            return tmp;
        }

        static void deleteDuplicates(ListNode head) {
            Hashtable table = new Hashtable();
            ListNode previous = null;
            while (head != null) {
                if (table.containsKey(head.data)) {
                    previous.next = head.next;
                } else {
                    table.put(head.data, true);
                    previous = head;
                }
                head = head.next;
            }
        }

        static void printLinkedList(ListNode headA) {
            while(headA != null) {
                System.out.print(headA.data + " ");
                headA = headA.next;
            }
            System.out.println();
        }
    }
}

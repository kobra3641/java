package ru.uppskilling;

public class Main {

    public static void main(String[] args) {
	    LinkedList list = new LinkedList();
        list.head = new LinkedList.Node(85);
        list.head.next = new LinkedList.Node(15);
        list.head.next.next = new LinkedList.Node(4);
        list.head.next.next.next = new LinkedList.Node(20);

        list.printList(list.head);
        System.out.println();
        list.head = list.reverse(list.head);
        list.printList(list.head);
        System.out.println();
        list.head = list.reverseRecursive(list.head);
        list.printList(list.head);
        System.out.println();

    }
}

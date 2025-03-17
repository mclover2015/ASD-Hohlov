import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class lb5 {

    public static Node duplicateOdd(Node head) {
        Node current = head;

        while (current != null) {
            if (current.data % 2 != 0) {
                Node duplicate = new Node(current.data);

                duplicate.prev = current.prev;
                duplicate.next = current;
                if (current.prev != null) {
                    current.prev.next = duplicate;
                } else {
                    head = duplicate;
                }
                current.prev = duplicate;

                current = current.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void start(Scanner scanner) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;

        System.out.println("Original list:");
        printList(n1);

        Node newHead = duplicateOdd(n1);

        System.out.println("Modified list:");
        printList(newHead);
    }
}

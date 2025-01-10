import java.util.*;
public class CopyLinkedList {
    static private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
//        Node head = new Node(1);
//        Node second = new Node(2);
//        head.next = second;
//        Node third = new Node(3);
//        second.next = third;
//        Node fourth = new Node(4);
//        third.next = fourth;
//        Node fifth = new Node(5);
//        fourth.next = fifth;
//
//        printList(head);
//
//        Node other = new Node(10);
//        other.next = third;
//
//        copyList(head, other);


        String result = getWrongAnswers(3, "ABA");
        System.out.println(result);
    }

    public static void copyList(Node head, Node other) {
        Node copy = new Node(head.val);
        copy.next = head.next;
        while(head.next != null) {
            Node next = new Node(head.next.val);

            if (other.next.val == copy.val) {
                other.next = copy;
            }

            head = head.next;
            next = next.next;
        }

        printList(copy);
    }

    public static void printList(Node node) {
        System.out.println("printList...");
        while(node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static String getWrongAnswers(int N, String C) {
        // Write your code here
        String str = "";
        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'A') {
                str += "B";
            } else {
                str += "A";
            }
        }

        return str;
    }
}

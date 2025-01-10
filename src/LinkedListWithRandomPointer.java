import java.util.*;

class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

class LinkedListWithRandomPointer {
    static Node cloneLinkedList(Node head) {
        // map to store nodes in the linked list
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;

        // traverse linked list and copy each node and data
        while (current != null) {
            map.put(current, new Node(current.data));
            current = current.next;
        }

        // reset current node
        current = head;

        // traverse list of nodes and copy next and random pointers
        while (current != null) {
            Node temp = map.get(current);
            temp.next = map.get(current.next);
            temp.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "(");
            if (head.random != null)
                System.out.print(head.random.data + ")");
            else
                System.out.print("null" + ")");

            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating a linked list with random pointer
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Print the original list
        System.out.println("Original linked list:");
        printList(head);

        // Function call
        Node clonedList = cloneLinkedList(head);

        System.out.println("Cloned linked list:");
        printList(clonedList);
    }
}

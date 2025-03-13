class MyLinkedList {
    private LinkedNode head;

    private static class LinkedNode {
        int data;
        LinkedNode next;

        LinkedNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        LinkedNode newNode = new LinkedNode(data);
        if (head == null) {
            head = newNode;
        } else {
            LinkedNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        LinkedNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public boolean search(int key) {
        LinkedNode temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void remove(int key) {
        if (head == null) {
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        LinkedNode temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.display(); // Output: 1 -> 2 -> 3 -> null

        list.remove(2);
        list.display(); // Output: 1 -> 3 -> null

        System.out.println("Search 2: " + list.search(2)); // Output: false
        System.out.println("Search 3: " + list.search(3)); // Output: true
    }
}

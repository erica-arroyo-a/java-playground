class MyQueue<T> {

    private Node<T> root;

    public MyQueue(T value) {
        root = new Node<T>(value);
    }

    public void enque(T value) {
        Node<T> node = new Node<T>(value);
        node.setNext(root);
        root = node;
    }

    public Node<T> deque() {

        Node<T> node = root;
        Node<T> previous = null;

        while(node.next() != null) {
            previous = node;
            node = node.next();
        }
        node = previous.next();
        previous.setNext(null);
        return node;
    }

    static class Node<T> {

        private T value;
        private Node<T> next;

        public Node (T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> next() {
            return next;
        }
    }

    // FIFO: first in, first out
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(5);

        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.deque();

        System.out.print("Queue: " + queue.root.value);
    }
}
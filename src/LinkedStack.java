import java.util.NoSuchElementException;

public class LinkedStack<T> {

    private Node<T> top;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.peek()); // Output: 2
        System.out.println(stack.isEmpty()); // Output: false
    }
}
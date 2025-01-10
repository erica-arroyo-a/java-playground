import java.util.Stack;

public class QueueUsingStacks<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T element) {
        // Add elements to stack1
        stack1.push(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Remove element from stack2
        return stack2.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Return the top element from stack2
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main (String[] args)
    {
        QueueUsingStacks<Integer> q = new QueueUsingStacks<>();
        q.enqueue(1);
        q.enqueue(100);
        q.enqueue(54);
        q.enqueue(9);
        q.enqueue(7);

        System.out.println(q.peek());
        System.out.println(q.isEmpty());

        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}
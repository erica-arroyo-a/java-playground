import java.util.ArrayList;
import java.util.List;

/**
 * A Min heap is typically represented as an array.
 *
 *
 * The root element will be at arr[0].
 * For any ith node arr[i]:
 * arr[(i -1) / 2] returns its parent node.
 * arr[(2 * i) + 1] returns its left child node.
 * arr[(2 * i) + 2] returns its right child node.
 */
class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0 && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapify(0);
        return min;
    }

    private void heapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

    // Function to insert a new element into the min-heap
    public static void insertMinHeap(int[] heap, int size, int value) {
        // Add the new element to the end of the heap
        heap[size] = value;
        // Get the index of the last element
        int index = size;
        // Compare the new element with its parent and swap
        // if necessary
        while (index > 0
                && heap[(index - 1) / 2] > heap[index]) {
            swapElements(heap, index, (index - 1) / 2);
            // Move up the tree to the parent of the current
            // element
            index = (index - 1) / 2;
        }
    }

    // Function to swap two elements in an array
    private static void swapElements(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // using MinHeap class with ArrayList
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(6);

        minHeap.printHeap(); // Example heap structure

        System.out.println("Extracted Min: " + minHeap.extractMin());
        minHeap.printHeap(); // Heap after extraction

        // using array
        int[] heap = new int[6];
        int[] values = { 10, 7, 11, 5, 4, 13 };
        int size = 0;
        for (int i = 0; i < values.length; i++) {
            insertMinHeap(heap, size, values[i]);
            size++;
            System.out.print("Inserted " + values[i]
                    + " into the min-heap: ");
            for (int j = 0; j < size; j++) {
                System.out.print(heap[j] + " ");
            }
            System.out.println();
        }
    }
}

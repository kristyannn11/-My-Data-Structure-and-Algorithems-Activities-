// LastnameHeap.java
public class AntiojoHeap {
    private int[] heap;
    private int size;

    public AntiojoHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert an element into the heap
    public void insert(int value) {
        if (size >= heap.length) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp();
    }

    // Move the newly added element up to maintain the heap property
    private void heapifyUp() {
        int index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Swap two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Return the index of the parent node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Get the maximum value (root) of the heap
    public int getMax() {
        if (size == 0) return -1;  // Heap is empty
        return heap[0];
    }

    // Remove the max (root) value and maintain the heap property
    public int deleteMax() {
        if (size == 0) return -1;  // Heap is empty
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return max;
    }

    // Move the root down to restore the heap property
    private void heapifyDown() {
        int index = 0;
        while (leftChild(index) < size) {
            int largerChild = leftChild(index);
            if (rightChild(index) < size && heap[rightChild(index)] > heap[largerChild]) {
                largerChild = rightChild(index);
            }

            if (heap[index] >= heap[largerChild]) break;

            swap(index, largerChild);
            index = largerChild;
        }
    }

    // Get the index of the left child of a node
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Get the index of the right child of a node
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Test the heap
    public static void main(String[] args) {
        AntiojoHeap heap = new AntiojoHeap(10);

        heap.insert(4);
        heap.insert(10);
        heap.insert(3);
        heap.insert(5);
        heap.insert(1);
        heap.insert(8);
        heap.insert(2);
        heap.insert(7);
        heap.insert(6);
        heap.insert(9);

        heap.printHeap();  // Print the heap
        System.out.println("Max value: " + heap.getMax());

        System.out.println("Deleted Max: " + heap.deleteMax());
        heap.printHeap();  // Print the heap after deleting max
    }
}

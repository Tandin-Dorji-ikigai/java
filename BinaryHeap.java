public class BinaryHeap {

    int[] binaryheap;
    int size;

    BinaryHeap() {
        binaryheap = new int[1];
        size = 0;
    }

    void insertElement(int element) {
        if (size == binaryheap.length - 1) {
            resizeHeap(binaryheap.length * 2);
        }

        size++;
        binaryheap[size] = element;
        for (int i = size / 2; i > 0; i--) {
            heapify(binaryheap, size, i);
        }
    }

    private void resizeHeap(int newSize) {
        int[] tempArray = new int[newSize];
        for (int i = 1; i <= size; i++) {
            tempArray[i] = binaryheap[i];
        }
        binaryheap = tempArray;
    }

    private void heapify(int[] array, int size, int i) {
        int largest = i;
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;

        if (leftChildIndex < size && array[leftChildIndex] > array[largest]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < size && array[rightChildIndex] > array[largest]) {
            largest = rightChildIndex;
        }

        int temp = array[i];
        array[i] = array[largest];
        array[largest] = temp;
    }

    void traverseElement() {
        for (int i = 1; i <= size; i++) {
            System.out.print(binaryheap[i] + " ");
        }
        System.out.println();
    }

    void deleteElement(int element) {
        int elementIndex = 0;

        for (int i = 1; i <= size; i++) {
            if (binaryheap[i] == element) {
                elementIndex = i;
                break;
            }
        }

        binaryheap[elementIndex] = binaryheap[size];
        binaryheap[size] = 0;
        size--;

        for (int i = elementIndex; i <= size / 2; i++) {
            heapify(binaryheap, size, i);
        }
    }

    public static void main(String[] args) {
        BinaryHeap obj = new BinaryHeap();

        obj.insertElement(10);
        obj.insertElement(5);
        obj.insertElement(15);
        obj.insertElement(8);
        obj.insertElement(12);
        obj.insertElement(7);

        obj.traverseElement();
        System.out.println();
        obj.deleteElement(15);
        obj.traverseElement();
    }
}

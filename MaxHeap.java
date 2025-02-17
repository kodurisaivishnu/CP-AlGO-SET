import java.util.*;

public class MaxHeap {
  private ArrayList<Integer> heap;

  public MaxHeap() {
    heap = new ArrayList<>();
  }

  private boolean offer(int num) {
    heap.add(num);
    heapifyUP(heap.size() - 1);
    return true;
  }

  private int poll() {
    if (heap.isEmpty()) {
      throw new NoSuchElementException("Heap is empty");
    }
    int num = heap.get(0);
    heap.set(0, heap.get(heap.size() - 1));
    heap.remove(heap.size() - 1);
    heapifyDown(0);
    return num;
  }

  private void heapifyDown(int i) {
    while (true) {
      int left = (i * 2 + 1);
      int right = (i * 2 + 2);
      int largest = i;

      if (left < heap.size() && heap.get(left) > heap.get(largest)) {
        largest = left;
      }
      if (right < heap.size() && heap.get(right) > heap.get(largest)) {
        largest = right;
      }

      if (largest != i) {
        Collections.swap(heap, i, largest);
        i = largest;
      } else {
        return;
      }
    }
  }

  private void heapifyUP(int i) {
    while (i > 0) {
      int parent = (i - 1) / 2;
      if (heap.get(parent) < heap.get(i)) {
        Collections.swap(heap, parent, i);
        i = parent;
      } else {
        return;
      }
    }

  }

  public String toString() {
    return heap.toString();
  }

  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap();
    maxHeap.offer(10);
    maxHeap.offer(9);
    maxHeap.offer(11);
    maxHeap.offer(12);
    System.out.println("poll: " + maxHeap.poll());
    System.out.println(maxHeap);

  }
}

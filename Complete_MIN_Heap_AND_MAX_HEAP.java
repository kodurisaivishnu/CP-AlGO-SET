/******************************************************************************

import java.util.*;
class MaxHeap{
    ArrayList<Integer> arr = new ArrayList<>();
    void insert(int ele){
        arr.add(ele);
        heapifyUP(arr.size()-1);
    }
    int poll(){
        if (arr.isEmpty()) throw new NoSuchElementException("Heap is empty");
        if (arr.size() == 1) return arr.remove(0);
        int val = arr.get(0);
        arr.set(0,arr.remove(arr.size() -1));
        heapifyDown(0);
        return val;
    }
    void heapifyUP(int i){
        int parent = (i-1) / 2;
        if(parent >= 0 && arr.get(i) > arr.get(parent)){
            Collections.swap(arr,i,parent);
            i = parent;
            heapifyUP(i);
        }
    }
    
    void heapifyDown(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int larget = i;
        if(left<arr.size() && arr.get(left) > arr.get(larget)){
            larget = left;
        }
        if(right < arr.size() && arr.get(right) > arr.get(larget)){
            larget = right;
        }
        
        if(i != larget){
            Collections.swap(arr,i,larget);
            heapifyDown(larget);
        }
    }
}

class MinHeap{
    ArrayList<Integer> arr = new ArrayList<>();
    void insert(int ele){
        arr.add(ele);
        heapifyUP(arr.size()-1);
    }
    
    int poll(){
        if (arr.isEmpty()) throw new NoSuchElementException("Heap is empty");
        if (arr.size() == 1) return arr.remove(0);
        int val = arr.get(0);
        arr.set(0,arr.remove(arr.size()-1));
        heapifyDown(0);
        return val;
    }
    void heapifyDown(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int min = i;
        if(left < arr.size() && arr.get(left) < arr.get(min)){
            min = left;
        }
        if(right < arr.size() && arr.get(right) < arr.get(min)){
            min = right;
        }
        
        if(i != min){
            Collections.swap(arr,i,min);
            heapifyDown(min);
        }
    }
    
    void heapifyUP(int i){
        int parent = (i-1) / 2;
        if(parent >= 0  && arr.get(i) < arr.get(parent)){
            Collections.swap(arr,i,parent);
            heapifyUP(parent); 
        }
    }
    
}
public class Main
{
    
	public static void main(String[] args) {
		MinHeap pq = new MinHeap();
		pq.insert(1);
		pq.insert(12);
		pq.insert(12);
		pq.insert(12);
		pq.insert(12);
		pq.insert(3);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}



import java.util.*;
class QuickSort {
  public void sort(int arr[]) {
    int lb = 0;
    int ub = arr.length - 1;
    qs(arr, lb, ub);
  }

  public void qs(int arr[], int lb, int ub) {
    if (lb < ub) {
      int loc = part(arr, lb, ub);
      qs(arr, lb, loc - 1);
      qs(arr, loc + 1, ub);
    }
  }

  public int part(int arr[], int lb, int ub) {
    int s = lb;//insted of lb-1
    int e = ub-1;
    int pivot = arr[ub]; 
    while (s <= e) {
      while (s <= e && arr[s] <= pivot) {
        s++;
      }
      while (s <= e && arr[e] > pivot) {
        e--;
      }
      if (s < e) {
        swap(arr, s, e);
      }
    }
    swap(arr, s, ub);  //swap s,ub insted lb ,e
    return s; //return s insted of e
  }

  public void swap(int arr[], int a, int b) {
    int t = arr[a];
    arr[a] = arr[b];
    arr[b] = t;
  }
   public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int arr[] = { 2, 1, 3, 4, 1, 33, 4, 5 };
        qs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

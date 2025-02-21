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
    int s = lb + 1;
    int e = ub;
    int pivot = arr[lb];
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
    swap(arr, lb, e);
    return e;
  }

  public void swap(int arr[], int a, int b) {
    int t = arr[a];
    arr[a] = arr[b];
    arr[b] = t;
  }
}

class MergeSort {
  public void sort(int arr[]) {
    int lb = 0;
    int ub = arr.length - 1;
    ms(arr, lb, ub);
  }

  public void ms(int arr[], int lb, int ub) {
    if (lb < ub) {
      int mid = (lb + ub) / 2;
      ms(arr, lb, mid);
      ms(arr, mid + 1, ub);
      merge(arr, lb, mid, ub);
    }
  }

  public void merge(int arr[], int lb, int mid, int ub) {
    int l = lb;
    int r = mid + 1;
    int temp[] = new int[ub - lb + 1];
    int k = 0;
    while (l <= mid && r <= ub) {
      if (arr[l] <= arr[r]) {
        temp[k++] = arr[l++];
      } else {
        temp[k++] = arr[r++];
      }
    }
    while (l <= mid) {
      temp[k++] = arr[l++];
    }
    while (r <= ub) {
      temp[k++] = arr[r++];
    }

    // coping the elemets
    for (int i = 0; i < k; i++) {
      arr[lb + i] = temp[i];
    }
  }
}

class CountingSort {
  public void sort(int arr[]) {
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();

    int range = max - min + 1;
    int cnt[] = new int[range];

    for (int i = 0; i < arr.length; i++) {
      cnt[arr[i] - min]++;
    }

    int k = 0;
    for (int i = 0; i < range; i++) {
      while (cnt[i]-- > 0) {
        arr[k++] = i + min;
      }
    }
  }
}

class InsertionSort {
  public void sort(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
      int j = i - 1;
      int t = arr[i];
      while (j >= 0 && arr[j] > t) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = t;
    }
  }
}

class SelectionSort {
  public void sort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      int mini = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[mini] > arr[j]) {
          mini = j;
        }
      }
      if (i != mini)
        swap(arr, i, mini);
    }
  }

  void swap(int arr[], int a, int b) {
    if (a != b) {
      arr[a] = arr[a] ^ arr[b];
      arr[b] = arr[a] ^ arr[b];
      arr[a] = arr[a] ^ arr[b];
    }
  }

}

class BubbleSort {
  public void sort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      boolean swapDone = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swapDone = true;
          swap(arr, j, j + 1);
        }
      }
      if (!swapDone)
        break;
    }
  }

  public void swap(int arr[], int a, int b) {
    int t = arr[a];
    arr[a] = arr[b];
    arr[b] = t;
  }
}

public class Sortings {
  public static void main(String[] args) {
    int arr[] = { 2, 1, 3, 4, 1, 33, 4, 5 };
    BubbleSort bs = new BubbleSort();
    bs.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}

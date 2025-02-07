import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BukketSort {
  public static String bukketSort(int arr[]) throws Exception {
    ArrayList<Integer> bucket[] = new ArrayList[32];
    for (int i = 0; i < 32; i++)
      bucket[i] = new ArrayList<>();
    ArrayList<Integer> ind[] = new ArrayList[32];
    for (int i = 0; i < 32; i++)
      ind[i] = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      int cnt = Integer.bitCount(arr[i]);
      bucket[cnt].add(arr[i]);
      ind[cnt].add(i);
    }
    for (ArrayList<Integer> b : bucket) {
      Collections.sort(b);
    }
    for (int i = 0; i < 32; i++) {
      ArrayList<Integer> b = bucket[i];
      ArrayList<Integer> in = ind[i];
      for (int j = 0; j < b.size(); j++) {
        arr[in.get(j)] = b.get(j);
      }
    }
    return Arrays.toString(arr);
  }

  public static void main(String[] args) throws Exception {
    int arr[] = { 3, 2, 4, 1 };
    System.out.println(bukketSort(arr));
  }
}

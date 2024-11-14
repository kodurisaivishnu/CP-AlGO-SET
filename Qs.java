import java.util.Arrays;

public class Qs {

    public static void swap(int arr[], int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    private static int part(int arr[], int l, int r) {
        int p = arr[l];
        int s = l;
        for (int e = l + 1; e <= r; e++) {
            if (arr[e] <= p) {
                s++;
                swap(arr, s, e);
            }
        }
        swap(arr, l, s);
        return s;
    }

    private static void qs(int arr[], int l, int r) {
        // if (l == r)
        //     return;
        if (l < r) {
            int loc = part(arr, l, r);
            qs(arr, l, loc-1);
            qs(arr, loc + 1, r);
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 4, 1, 0, 5, 6};
        int arr[] = { 5,4,3,2,1};
        qs(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

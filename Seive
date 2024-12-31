import java.util.*;

public class Seive {

  static HashSet<Integer> seive() {
    HashSet<Integer> st = new HashSet<>();
    int n = (int) 1e4;
    boolean mark[] = new boolean[n + 1];
    mark[0] = mark[1] = true;
    for (int i = 2; i * i <= n; i++) {
      if (!mark[i]) {
        for (int j = i * i; j <= n; j = j + i) {
          mark[j] = true;
        }
      }
    }
    for (int i = 2; i < n; i++) {
      if (!mark[i]){
        st.add(i);
      }
    }
    return st;
  }

  public static void main(String[] args) {

    System.out.println("size : " + seive().size());
    System.out.println(seive());

  }
}

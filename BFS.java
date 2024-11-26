import java.util.Deque;
import java.util.LinkedList;

public class BFS {
  private static void BFS(int g[][], int src) {
    int v = g.length;
    boolean vis[] = new boolean[v];
    Deque<Integer> q = new LinkedList<>();
    q.add(src);
    vis[src] = true;
    while (!q.isEmpty()) {
      int node = q.poll();
      System.out.print(node + " ");
      for (int j = 0; j < v; j++) {
        if (!vis[j]) {
          vis[j] = true;
          q.add(j);
        }
      }
    }
  }

  public static void main(String args[]) {
    int[][] g = {
      {0, 1, 1, 0, 0, 0, 0, 0},  // Node 0 is connected to Node 1, 2
      {1, 0, 0, 1, 0, 0, 0, 0},  // Node 1 is connected to Node 0, 3
      {1, 0, 0, 0, 1, 0, 0, 0},  // Node 2 is connected to Node 0, 4
      {0, 1, 0, 0, 0, 1, 0, 0},  // Node 3 is connected to Node 1, 5
      {0, 0, 1, 0, 0, 0, 1, 0},  // Node 4 is connected to Node 2, 6
      {0, 0, 0, 1, 0, 0, 0, 1},  // Node 5 is connected to Node 3, 7
      {0, 0, 0, 0, 1, 0, 0, 0},  // Node 6 is connected to Node 4
      {0, 0, 0, 0, 0, 1, 0, 0}   // Node 7 is connected to Node 5
  };
  
    int src = 0;
    BFS(g, src);
  }
}

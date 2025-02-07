import java.util.*;

public class binary {
  public static void sol(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int n) {
    if (temp.size() == n) {
      ans.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i < 2; i++) { // numeber of choces can vary on 2 = n
         //if (!temp.isEmpty() && temp.get(temp.size() - 1) == 1 && i == 1) continue; if without consecutive ones
        temp.add(i);
        sol(ans, temp, n);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number: ");
    int n = sc.nextInt();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    sol(ans, new ArrayList<>(), n);
    System.out.println(ans);
  }
}

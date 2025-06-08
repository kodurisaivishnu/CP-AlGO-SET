class FactorialMod {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100_005;
    static long[] fact = new long[MAX];

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
    }

    static long factorial(int n) {
        return fact[n];
    }
}

class Solution{
  public class Main {
    public static void main(String[] args) {
        FactorialMod.precompute();
        System.out.println(FactorialMod.factorial(5));      // 120
        System.out.println(FactorialMod.factorial(10));     // 3628800
        System.out.println(FactorialMod.factorial(100000)); // Huge number % MOD
    }
}

}

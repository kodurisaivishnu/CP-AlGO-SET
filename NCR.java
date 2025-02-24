public class NCR {

  static int bruteNcR(int n, int r) {
    int ans = 1;
    for (int i = 0; i < r; i++) {
      ans = ans * (n - i);
      ans = ans / (i + 1);
    }
    return ans;
  }

  static final int mod = (int) 1e9 + 7;
  static final int N = (int) 1e6 + 10;
  static int[] fact = new int[N];

  static void precomputeFactorials() {
    fact[0] = 1;
    for (int i = 1; i < N; i++) {
      fact[i] = (int) ((1L * i * fact[i - 1]) % mod);
    }
  }

  static int NcR(int n, int r) {
    if (r > n) {
      return 0; // Invalid case
    }
    precomputeFactorials();
    return (int) (((1L * fact[n] * inverse(fact[r])) % mod * inverse(fact[n - r])) % mod);
  }

  static int inverse(int num) {
    return binExp(num, mod - 2); // Fermat's Little Theorem
  }

  static int binExp(int x, int n) {
    int ans = 1;
    while (n > 0) {
      if (n % 2 == 1) {
        ans = (int) ((1L * ans * x) % mod);
      }
      x = (int) ((1L * x * x) % mod);
      n /= 2;
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 3;
    int r = 2;
    System.out.println(NcR(n, r));
  }
}

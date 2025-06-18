public class nCr {
    final long MOD = (long) 1e9 + 7;
    long[] fact;
    long[] invFact;

    // Fast exponentiation
    long pow(long x, long n) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = (ans * x) % MOD;
                n--;
            }
            x = (x * x) % MOD;
            n /= 2;
        }
        return ans;
    }

    // Precompute factorial and inverse factorial up to MAX
    void precomputeFact(int MAX) {
        fact = new long[MAX + 1];
        invFact = new long[MAX + 1];
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX] = pow(fact[MAX], MOD - 2);
        for (int i = MAX - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Standard nCr using precomputed arrays
    long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public static void main(String[] args) {
        nCr comb = new nCr();

        // Example: precompute factorials up to MAX = 1000000
        comb.precomputeFact(1000000);

        // Example usage:
        int n = 10, r = 3;
        System.out.println("C(" + n + ", " + r + ") = " + comb.nCr(n, r));

        n = 20; r = 5;
        System.out.println("C(" + n + ", " + r + ") = " + comb.nCr(n, r));

        n = 1000; r = 500;
        System.out.println("C(" + n + ", " + r + ") = " + comb.nCr(n, r));
    }
}























// import java.util.Arrays;

// public class NCR {
//   static final int mod = (int) 1e9 + 7;
//   static final int N = (int) 1e5 + 10;
//   static long[] fact = new long[N];
//   static long[] invFact = new long[N];

//   // Precompute factorials and inverse factorials for O(1) NcR calculation
//   static void precomputeFactorials() {
//     fact[0] = 1;
//     for (int i = 1; i < N; i++) {
//       fact[i] = (fact[i - 1] * i) % mod;
//     }
//     invFact[N - 1] = modExp(fact[N - 1], mod - 2);
//     for (int i = N - 2; i >= 0; i--) {
//       invFact[i] = (invFact[i + 1] * (i + 1)) % mod;
//     }
//   }

//   // Fast exponentiation for modular inverse (used in precomputed factorial method)
//   static long modExp(long x, long y) {
//     long res = 1;
//     while (y > 0) {
//       if ((y & 1) == 1) res = (res * x) % mod;
//       x = (x * x) % mod;
//       y >>= 1;
//     }
//     return res;
//   }

//   // 1. Brute force NcR (O(r)): Simple but slow for large r
//   static int bruteNcR(int n, int r) {
//     if (r > n) return 0;
//     long ans = 1;
//     for (int i = 0; i < r; i++) {
//       ans = ans * (n - i) / (i + 1);
//     }
//     return (int) ans;
//   }

//   // 2. DP NcR (O(n²)): Computes full Pascal’s Triangle
//   static int[][] dpNcr(int n) {
//     int[][] dp = new int[n + 1][n + 1];
//     for (int i = 0; i <= n; i++) {
//       for (int j = 0; j <= i; j++) {
//         if (j == 0 || j == i) dp[i][j] = 1;
//         else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
//       }
//     }
//     return dp;
//   }

//   // 3. Optimized DP NcR (O(n * r)): Space-efficient DP
//   static int DpOpNcR(int n, int r) {
//     if (r > n) return 0;
//     int[] dp = new int[r + 1];
//     dp[0] = 1;
//     for (int i = 1; i <= n; i++) {
//       for (int j = Math.min(i, r); j > 0; j--) {
//         dp[j] = (dp[j] + dp[j - 1]) % mod;
//       }
//     }
//     return dp[r];
//   }

//   // 4. Optimized NcR using Precomputed Factorials (O(1) per query)
//   static int NcR(int n, int r) {
//     if (r > n) return 0;
//     return (int) (((fact[n] * invFact[r]) % mod * invFact[n - r]) % mod);
//   }

//   public static void main(String[] args) {
//     precomputeFactorials();
//     int n = 10, r = 3;
    
//     System.out.println("Brute force NcR: " + bruteNcR(n, r));
//     System.out.println("DP NcR: " + dpNcr(n)[n][r]);
//     System.out.println("Optimized DP NcR: " + DpOpNcR(n, r));
//     System.out.println("Optimized NcR with Precomputed Factorials: " + NcR(n, r));
//   }
// }


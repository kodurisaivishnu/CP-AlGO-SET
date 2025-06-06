class Solution {
    static final long MOD = (long)1e9 + 7;
    static final long BASE = 31; // Slightly better than 26 due to fewer collisions

    long computeHash(String s) {
        long hash = 0, power = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            hash = (hash + (s.charAt(i) - 'a' + 1) * power % MOD) % MOD;
            power = (power * BASE) % MOD;
        }
        return hash;
    }

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = pat.length(), n = txt.length();
        if (m > n) return ans;

        long patHash = computeHash(pat);
        long curHash = computeHash(txt.substring(0, m));

        long maxPow = 1;
        for (int i = 1; i < m; i++) maxPow = (maxPow * BASE) % MOD;

        if (curHash == patHash && txt.substring(0, m).equals(pat)) {
            ans.add(1);
        }

        for (int i = m; i < n; i++) {
            // Remove leftmost character
            long leftChar = (txt.charAt(i - m) - 'a' + 1) * maxPow % MOD;
            curHash = (curHash - leftChar + MOD) % MOD;

            // Shift window and add new character
            curHash = (curHash * BASE) % MOD;
            curHash = (curHash + (txt.charAt(i) - 'a' + 1)) % MOD;

            if (curHash == patHash && txt.substring(i - m + 1, i + 1).equals(pat)) {
                ans.add(i - m + 2); // 1-based index
            }
        }

        return ans;
    }
}


public class Rabin_Crap_StringMatch{
  public static void main(Sting args[]){
    String text = "geeksforgeeks", pattern = "geek";
    ArrayList<Integer> ans = new Solution().search(text,pat);
    System.out.println(ans);
  }
}

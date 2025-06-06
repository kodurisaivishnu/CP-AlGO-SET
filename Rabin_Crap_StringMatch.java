class Solution {
    static long mod = (int)(1e9+7);
    static long BASE = 26;
    
    long hashValue(String s){
        int m = s.length();
        long val = 1;
        long res = 0;
        for(int i = m-1;i>=0;i--){
            res = ( res + val * ( s.charAt(i)-'a' ) ) % mod;
            val = (val*26) % mod;
        }
        return res;
    }
    ArrayList<Integer> search(String pat, String txt) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        long MAX = 1;
    
        for(int i = 0;i<m-1;i++) MAX = (MAX  * 26) % mod; //26^(m-1)
        
        long targetVal = hashValue(pat);
        //first window
        long cur = hashValue(txt.substring(0,m));
        if(targetVal == cur && txt.substring(0,m).equals(pat)){
                ans.add(1);
        }
        
        for(int i = m;i<n;i++){
            cur = ( cur - ( (txt.charAt(i - m) - 'a') * MAX) % mod + mod) % mod;

            cur = ( cur * 26) % mod;
            cur = ( cur + txt.charAt(i)-'a') % mod;
            
            if(cur == targetVal && txt.substring(i-m+1,i+1).equals(pat)){
                ans.add(i-m+2); // for one based indexing
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

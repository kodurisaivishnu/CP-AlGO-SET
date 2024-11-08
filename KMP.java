import java.util.*;
class KMP {
    private static int[] calc_lps(String t){ //t is a pattern
        int n = t.length();
        int lps[] = new int[n];
        int i = 0;
        int j =1;
        while(j<n){
            if(t.charAt(i) == t.charAt(j)){
                i++;
                lps[j] = i;
                j++;
            }else{
                if(i == 0){
                    j++;
                }else{ //i!=0;
                    i = lps[i-1];
                }
            }
        }
        
        return lps;
    }
    private static boolean KMP_Search(String txt,String t){
        int i=0; //for text
        int j=0; //for t = pattern
        int lps[] = calc_lps(t);
        // System.out.println(Arrays.toString(lps));
        int m = txt.length();
        int n = t.length();
        while(i < m){
            if(txt.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            if(j == n) return true; //we have our target
            else if(i<m && txt.charAt(i) != t.charAt(j)){
                if(j!=0) j = lps[j-1];
                else i++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String text ="ababcabcabababd";
        String pattern = "ababd";
        System.out.println(KMP_Search(text,pattern));
    }
}

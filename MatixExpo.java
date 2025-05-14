class MatrixExpo{
  static long mod = (long)(1e9+7);
    long[][] multiplyMatrix(long A[][],long B[][]){
        int r1 = A.length;
        int c1 = A[0].length;
        int r2 = B.length;
        int c2 = B[0].length;

        long res[][] = new long[r1][c2];
        for(int i = 0;i<r1;i++){
            for(int j = 0;j<c2;j++){
                res[i][j] = 0;
                for(int k = 0;k<c1;k++){
                    res[i][j] = (res[i][j] + (A[i][k] * B[k][j]) % mod) % mod;
                }
            }
        }
        return res;
    }

    long[][] matrixExp(long M[][],int n){
        int len = M[0].length; //col length
        long I[][] = new long[len][len]; //identity matrix
        for(int i = 0;i<len;i++) I[i][i]=1l;


        long res[][] = I;
        while(n != 0){
            if((n&1) == 1){
                res = multiplyMatrix(M,res);
            }
            M = multiplyMatrix(M,M);
            n = n/2;
        }
        return res;
    }
  public static void main(String args[]){
    
  }
}

public class BS_LB_UB{
   static int lb(int arr[],int t){
        int l=0;
        int r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] >= t){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    static int ub(int arr[],int t){
        int l=0;
        int r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] > t){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
  public static void main(String args[]){
    int arr[] = {-1,-2,0,0,4,5};
    System.out.println(lb(arr,0)+" ----- "+ub(arr,0));
  }
}

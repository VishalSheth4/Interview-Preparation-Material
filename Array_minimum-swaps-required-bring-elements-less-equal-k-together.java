// step 1) Count value of less than K == cnt
// step 2) count value greater than K upto cnt
// step 3) now work as sliding windows part in for loop increase and decrease bad value as per condition...
public class Main
{
    static int minSwap(int a[], int n, int k ){
        // Find smaller than or equal to K.
        int cnt =0;
        for(int i=0;i<n;i++){
            if(a[i] <= k){
                cnt++;
            }
        }
        // Now find greater than K.
        int bad = 0;
        for (int i = 0; i < cnt; ++i){
            if (a[i] > k){
                ++bad;
            }
        }
        int ans = bad;
        for(int i=0, j=cnt; j<n; j++,i++){
            if(a[i]<=k){
                bad++;
            }else{
                bad--;
            }
        }
        ans = Math.min(ans,bad);
        return ans;
    }
	public static void main(String[] args) {
	    
		System.out.println("Hello World");
		
		int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.print(minSwap(arr, n, k) + "\n");
	}
}

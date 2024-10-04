import java.util.*;
public class Main
{
    static void maxtwobuysell(int prices[], int n, int k){
        int[][] dp = new int[k+1][n];

        for(int t=1; t<=k; t++){
            int max = Integer.MIN_VALUE;
            for(int d=1; d<n; d++){
                if(dp[t-1][d-1] - prices[d-1] > max){
                    max = dp[t-1][d-1] - prices[d-1];                    
                }
                
                if(max + prices[d] > dp[t][d-1]){
                    dp[t][d] = max + prices[d];
                }else{
                    dp[t][d] = dp[t][d-1];
                }
            }
        }
        System.out.println(dp[k][n-1]);
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[] = { 2, 30, 15, 10, 8, 25, 80 };
        int size = arr.length;
        int kTimes = 3;
        // System.out.println(maxtwobuysell(arr, size, kTimes));
        maxtwobuysell(arr, size, kTimes);
	}
}

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static boolean solve(int cookRank[], int n, int parathas,int mid){
        int time = 0;
        int totalParathas = 0;
        for(int i=0;i<n;i++){
            time = cookRank[i];
            int j = 2;
            while(time<=mid){
                totalParathas++;
                time = time + (cookRank[i]*j);
                j++;
            }
            if(totalParathas > parathas){
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int parathas = 10;
		int cook[] = {1,2,3,4};  // Cook ranking Given 
		int ans = 0;
		int lb = 0;
		int ub = 100; // Max Value
		while(lb <= ub){
		    int mid = (lb+ub)/2;
		    if(solve(cook,cook.length,parathas,mid)){
		        ans = mid;
		        ub = mid-1;
		    }else{
		        lb = mid +1;
		    }
		}
		System.out.println(ans);
		
	}
}

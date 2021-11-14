/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    public static void findCommonEle(int a1[], int a2[], int a3[]){
        int i=0;
        int j=0;
        int k=0;
        
        int prev1 = Integer.MIN_VALUE;
        int prev2 = Integer.MIN_VALUE;
        int prev3 = Integer.MIN_VALUE;
        while(i<a1.length && j<a2.length && k<a3.length){
            while(i<a1.length && a1[i]==prev1){
                i++;
            }
            while(j<a2.length && a2[j]==prev2){
                j++;
            }
            while(k<a3.length && a3[k]==prev3){
                k++;
            }
            if(a1[i]==a2[j] && a2[j]==a3[k] && i<a1.length && j<a2.length && k<a3.length){
                System.out.println(a1[i]);
                prev1 = a1[i];
                prev2 = a2[j];
                prev3 = a3[k];
                i++;
                j++;
                k++;
                // System.out.println(a1[i]);
            }
            else if(a1[i]<a2[j]){
                prev1 = a1[i];
                i++;
            }else if(a2[j]<a3[k]){
                prev2 = a2[j];
                j++;
            }else{
                prev3 = a3[k];
                k++;
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int ar1[] = {1, 5, 10, 20,20, 40, 80}; 
        int ar2[] = {6, 7, 20,20, 80, 100};
        int ar3[] = {3, 4, 15, 20,20, 30, 70, 80, 120};
        
        findCommonEle(ar1, ar2,ar3);
        
	}
}

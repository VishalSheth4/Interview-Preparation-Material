/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int n = a.length;
        int key = 3;
        int low = 0;
        int high = a.length;
        int pivot = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]<a[mid+1%n] && a[mid]<a[(mid-1+n)%n]){
                pivot = mid;
                break;
            }else if(a[mid]>=a[0] && a[mid]>=a[n-1]){
                low = (mid+1)%n;
            }else{
                high = (mid-1+n)%n;
            }
        }
        System.out.println(pivot);
	}
}

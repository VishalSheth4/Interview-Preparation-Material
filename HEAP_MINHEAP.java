/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static void printArray(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+", ");
        }
    }
    static public void heapify(int a[], int n, int index){
        // System.out.println("n "+n+"index "+index);
        int largest = index;
        int left = (index*2)+1;
        int right = (index*2)+2;
        
        // left child is largest than root
        if(left<n && a[largest]<a[left]){
            largest = left;
        }
        // right child is largest than root
        if(right<n && a[largest]<a[right]){
            largest = right;
        }
        // If largest is not root
        if(largest!=index){
            int swap = a[index];
            a[index] = a[largest];
            a[largest] = swap;
            heapify(a,n,largest);
        }
    }
    static public void sort(int a[]){
        int n = a.length;
        // Build Heapify
        for(int i=(n/2)-1;i>=0;i--){
            heapify(a,n,i);
        }
        
        printArray(a);
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {12,11,13,5,6,7};
		int n = a.length;
		sort(a);
		printArray(a);
	}
}

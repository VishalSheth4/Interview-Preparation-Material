import java.util.*;
public class Main
{
    static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    static void heapify(int a[], int N, int i){
        // Initialize largest as root 
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        
        // if left child is larger than root.
        if(l<N && a[l]>a[largest])
            largest=l;
            
        // if right child is larger than root.
        if(r<N && a[r]>a[largest])
            largest=r;
        
        // if largest is not root;
        if(largest != i){
            swap(a,largest,i);
            heapify(a,N,largest);
        }
    }
    
    static void buildHeap(int a[], int N){
        // Find the Index of last non-leafNode
        int startIdx = (N/2)-1;
        
        // Perform reverse level order traversal
        // from last non-leaf node and heapify each node.
        
        for(int i=startIdx; i>=0; i--){
            heapify(a,N,i);
        }
    }

	public static void main(String[] args) {
	    
		System.out.println("Hello World");
		int a[] = {4,10,3,5,1};
		buildHeap(a,a.length);
		for(int i=0;i<a.length;i++){
		    System.out.println(a[i]);
		}
		
	}
}

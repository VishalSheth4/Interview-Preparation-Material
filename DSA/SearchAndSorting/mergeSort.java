// divide till 1 element
// sort (left side)
// sort (right side)
// merge ()

import java.util.*;
public class Main
{
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    static void merge(int a[], int l, int m, int r){
        int[] left = Arrays.copyOfRange(a, l, m + 1);
        int[] right = Arrays.copyOfRange(a, m + 1, r + 1);
        
        int i = 0, j = 0, k = l, swaps = 0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                a[k++]=left[i++];
            }else{
                a[k++]=right[j++];
            }
        }
        while(i<left.length)
            a[k++] = left[i++];
        while(j<right.length)
            a[k++] = right[j++];    
    }
    
    static void sort(int arr[], int l, int r){
        if(l<r){
            int m=(l+r)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr, l, m, r);
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given array is");
        printArray(arr);
        sort(arr, 0, arr.length - 1);
        printArray(arr);
	}
}

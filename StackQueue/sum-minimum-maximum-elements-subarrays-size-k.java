// arr[] = {2, 5, -1, 7, -3, -1, -2}  
// K = 4

import java.util.*;
public class Main
{
    public static int SumOfKsubArray(int a[] , int k){
        int sum=0;
        int i=0;
        Deque<Integer> S = new LinkedList<>();
        Deque<Integer> G = new LinkedList<>();
        for(i=0;i<k;i++){
            while(!S.isEmpty() && a[S.peekLast()] >= a[i]){
                S.removeLast();
            }
            while(!G.isEmpty() && a[G.peekLast()] <= a[i]){
                G.removeLast();
            }
            S.addLast(i);
            G.addLast(i);
        }
        for(; i<a.length;i++){
            sum +=a[S.peekFirst()] + a[G.peekFirst()];
            
            while(!S.isEmpty() && S.peekFirst() <= i-k){
                S.removeFirst();
            }
            while(!G.isEmpty() && G.peekFirst() <= i-k){
                G.removeFirst();
            }
            
            while(!S.isEmpty() && a[S.peekLast()] >= a[i]){
                S.removeLast();
            }
            while(!G.isEmpty() && a[G.peekLast()] <= a[i]){
                G.removeLast();
            }
            S.addLast(i);
            G.addLast(i);
        }
        sum +=a[S.peekFirst()] + a[G.peekFirst()];
        return sum;
        
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[] = {2, 5, -1, 7, -3, -1, -2} ; 
        int k = 3; 
        System.out.println(SumOfKsubArray(arr, k));
	}
}

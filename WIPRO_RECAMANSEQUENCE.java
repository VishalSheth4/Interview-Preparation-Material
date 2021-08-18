// Given Question
// a(0) = 0,
// if n > 0 and the number is not 
//   already included in the sequence,
//      a(n) = a(n - 1) - n 
// else 
//      a(n) = a(n-1) + n. 
// --------------------------------
// 0 : n=n0
// a[i-1]-i > 0 and the n is not repeated
// a[i+1]+i < 0 otherwiae


import java.util.*;
public class Main
{
    public static void recaman(int k){
        // 1st case 
        if (k<=0){
            return;
        }
        System.out.println(0);
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(0);
        
        // 2nd case
        int prev = 0;
        
        for(int i=0;i<k;i++){
            int curr = prev - i ;
            if(curr < 0 || hs.contains(curr)){
                curr = prev + i;
            }
            hs.add(curr);
            System.out.println(curr);
            prev = curr;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int k = 6;
		recaman(k);
	}
}

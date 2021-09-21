// space complxity : O(1)
// time complxity : O(n)

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Integer a[] = { 1, 2, 3, 4, 5, 6 };
		int n = a.length;
		Arrays.sort(a, new Comparator<Integer>(){
		    public int compare(Integer arg0, Integer arg1){
		        int c1 = Integer.bitCount(arg0);
		        int c2 = Integer.bitCount(arg1);
		        if(c1<=c2){
		            return 1;
		        }else{
		            return -1;
		        }
		    }
		});
		for(int i=0;i<n;i++){
		    System.out.println(a[i]);
		}
	}
}

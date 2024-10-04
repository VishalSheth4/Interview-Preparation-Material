
//BinarySearch_print_all_the_subaarray_with _sum_ZERO_0

import java.util.*;
class Pair{
    int first,second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
}
public class BinarySearch_print_all_the_subaarray_with{
	public static void main(String[] args) {
		System.out.println("Hello World");

		int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int n = arr.length;
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<>();
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == 0){
                out.add(new Pair(0,i));
            }
            
            ArrayList<Integer> al = new ArrayList<>();
            
            if(hmap.containsKey(sum)){
                al = hmap.get(sum);
                for(int j=0;j<al.size();j++){
                    out.add(new Pair(al.get(j)+1,i));
                }
            }
            
            al.add(i);
            hmap.put(sum,al);
        }
        
        for(Pair p : out) {
        	System.out.print(p.first+",");
        	System.out.print(p.second+"");
        	System.out.println();
        }
	}
}

package arrayRoadMap;
import java.util.*;
public class Arrays_minimum_number_swaps_required_sort_array{
    public static void swap(int a[] , int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {1,5,4,3,2};
		int temp[] = {1,5,4,3,2};
		int n = a.length;
// 		System.out.println(n);
		int swaps = 0;
		Arrays.sort(a);
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
		    hmap.put(a[i],i);
		}
		for(int i=0;i<n;i++){
		    if(a[i]==temp[i]){
		        
		    }else{
		        int swapIndex = hmap.get(temp[i]);
		        System.out.println(a[i]+" - "+i+" - "+swapIndex);
		        swap(temp,i,swapIndex);
		        swaps++;
		    }
		}
		System.out.println("SWAPS"+swaps);
	}
}

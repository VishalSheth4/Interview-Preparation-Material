import java.util.*;
public class Main
{
    static Set<List<Integer>> s = new HashSet<List<Integer>>(); 
    static void TwoSum(int a[], int target){
        int start = 0;
        int end = a.length-1;
        while(start <= end){
            int sum = a[start] + a[end];
            if(sum == target){
                s.add(Arrays.asList(a[start], a[end]));
                start++;
                end--;
            }else if(sum < target){
                start++;
            }else{
                end--;
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {7,6,5,4,0,3,2,1};
		int n = 7;
		Arrays.sort(a);
		// two Sum 
		TwoSum(a,n);
		System.out.println(s);
	}
}

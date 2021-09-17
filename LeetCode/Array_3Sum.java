import java.util.*;
public class Main
{
    static Set<List<Integer>> s = new HashSet<List<Integer>>(); 
    static void ThreeSum(int a[], int target){
        for(int i=0;i<a.length-1;i++){
            TwoSum(i,a,target);
        }
    }
    static void TwoSum(int i, int a[], int target){
        int start = i+1;
        int end = a.length-1;
        while(start < end){
            System.out.println(i+""+start+""+end);
            int sum = a[start] + a[end] + a[i];
            if(sum == target){
                s.add(Arrays.asList(a[start], a[end], a[i]));
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
    // TwoSum(a,n);
		
		ThreeSum(a,n);
		System.out.println(s);
	}
}

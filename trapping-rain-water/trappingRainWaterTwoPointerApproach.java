import java.util.*;
public class Main
{
    public static int maxWater(int a[] , int N){
        int result = 0;
        int left = 0;
        int right = N-1;
        int l_max = 0;
        int r_max = 0;
        while(left <=right){
            if(r_max <= l_max){
                result += Math.max(0 , r_max-a[right]);
                r_max = Math.max(r_max , a[right]);
                right--;
            }else{
                result += Math.max(0, l_max-a[left]);
                l_max = Math.max(l_max , a[left]);
                left++;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int N = arr.length;
        System.out.print(maxWater(arr, N));
	}
}

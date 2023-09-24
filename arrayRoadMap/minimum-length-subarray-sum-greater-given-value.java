public class Main
{
    public static int smallestSubWithSum(int a[], int len, int x){
        int curr_sum = 0;
        int min_len = len + 1;
        int start = 0;
        int end = 0;
        while(end < len){
            while(curr_sum <= x && end < len){
                curr_sum = curr_sum + a[end++];
            }
            
            while(curr_sum > x && start < len){
                if(end-start < min_len){
                    min_len = end-start;
                }
                curr_sum = curr_sum-a[start++];
            }
        }
        return min_len;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr1[] = { 1, 4, 45, 6, 10, 19 };
        int x = 51;
        int n1 = arr1.length;
        int res1 = smallestSubWithSum(arr1, n1, x);
        if (res1 == n1 + 1){
            System.out.println("Not Possible");
        }else{
            System.out.println(res1);
        }
	}
}

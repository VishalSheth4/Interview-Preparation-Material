public class Main
{
    static void swap(char ar[], int i, int j)
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    static void reverse(char ar[], int i, int j){
        while(i<j){
            swap(ar, i, j);
            i++;
            j--;
        }
    }
    
	public static void main(String[] args) {
	    char arr[] = { '5','3','4','9','7','6' };
        int n = arr.length;

        int i = 0;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1])
                break;
        }
        // i = 3 when break value = 9
        if (i != 0) {
            for (int j = n - 1; j >= i; j--) {
                if (arr[i - 1] < arr[j]) {
                    swap(arr, i - 1, j);
                    break;
                }
            }
        }
        // 
        reverse(arr, 0 + i, n-1);
        
        for(i=0;i<=n-1;i++){
            System.out.print(arr[i]);
        }
	}    
}

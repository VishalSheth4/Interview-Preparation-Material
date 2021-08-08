
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
// 		int arr[] = {3,4,8,2,2,8,3,1};
        int arr[] = { 2, 3, 7, 9, 11, 2, 3, 11};
		int n = arr.length;
		int sum=0;
		for (int i = 0; i < n; i++) {
		    
            // It removes pair elements...
            sum = (sum ^ arr[i]);
        }
        
        // It provides the common relation for both elements 
        // (IT GIVE the RIGHT MOST elements as 1 from both the unique elements)
        
        sum = (sum & -(sum));
        int sum1 = 0;
        int sum2 = 0;
 
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & sum) > 0) {
                sum1 = (sum1 ^ arr[i]);
                System.out.println(" sum1 "+sum1);
            }
            else {
                sum2 = (sum2 ^ arr[i]);
                System.out.println(" sum2 "+sum2);
            }
        }
        
    
        // My approach if 2 unique number is to find...
        // for (int i = 0; i < arr.length; i++) {

        //     if ((arr[i] & sum) == 0) {
        //         sum1 = sum1^arr[i];
        //         System.out.println(" sum1 "+sum1);
        //     }
        //     sum2=|sum1-sum|;
        // }
    
         System.out.println("The non-repeating elements are " + sum1 + " and " + sum2);
	}
}

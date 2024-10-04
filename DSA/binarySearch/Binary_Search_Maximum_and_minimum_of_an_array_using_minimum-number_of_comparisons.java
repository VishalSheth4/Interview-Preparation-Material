class Pair{
        int min;
        int max;
    }

// Even Condition : Do logic for 0 and 1 array position
// Odd Condition : Do not do anything 
// Maintain i position properly 
// In while loop i=i+2;

public class Main
{
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int a[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = new Pair();
        
        // CHECK for odd and even condition ;
        int i=0;
        if(arr_size%2==0){      // EVEN
            i = 2;
            if(a[0]>a[1]){
                minmax.max = a[0];
                minmax.min = a[1];
            }else{
                minmax.min = a[0];
                minmax.max = a[1];
            }
        }else{                 // ODD
            i=1;
                minmax.max = a[0];
                minmax.min = a[0];
        }
        
        while(i<arr_size-1){
            if(a[i]>a[i+1]){
                if(minmax.max < a[i])
                    minmax.max = a[i];
                if(minmax.min > a[i+1])
                    minmax.min = a[i+1];
            }else{
                if(minmax.max < a[i+1])
                    minmax.max = a[i+1];
                if(minmax.min > a[i])
                    minmax.min = a[i];
            }
            i=i+2;
        }
        
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
	}
}

/*
If n is odd:    3*(n-1)/2  
If n is even:   1 Initial comparison for initializing min and max, and 3(n-2)/2 comparisons for rest of the elements  
             =  1 + 3*(n-2)/2 = 3n/2-2
                      
*/

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
		int low = 14;
		int high = 20;
		int n = a.length;
		
		int start = 0;
		int end = n-1;
		int i=0;
		while (i<=end){
		    if(a[i]< low){
		        int temp = a[i];
		        a[i] = a[start];
		        a[start] = temp;
		        start++;
		        i++;
		    }
		    else if(a[i]>high){
		        int temp = a[i];
		        a[i] = a[end];
		        a[end] = temp;
		        end--;
		    }else{
		        i++;
		    }
		}
		for(int j =0;j<n;j++){
		    System.out.println(a[j]);
		}
		
	}
}

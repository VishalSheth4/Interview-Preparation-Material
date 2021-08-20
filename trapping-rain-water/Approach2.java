public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
// 		int a[] = {3, 0, 2, 0, 4};
        int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int len = a.length;
        int left[] = new int[len];
        int right[] = new int[len];
		int res = 0;
	
		  //  find max left
		    left[0]=a[0];
		      for(int j=1;j<len;j++){
		          left[j] = Math.max(left[j-1],a[j]);
		      }  
		  // find max right
  		      right[len-1]=a[len-1];
		      for(int j=len-2;j>0;j--){
		          right[j] = Math.max(right[j+1],a[j]);
		      }  
	      // find result
	      		for(int i=1;i<a.length-1;i++){
                    res = res + Math.min(left[i], right[i]) - a[i];
		        }
        		System.out.println(res);
	}
}

// This time Complexity is O(n)

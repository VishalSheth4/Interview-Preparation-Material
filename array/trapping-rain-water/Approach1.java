public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
// 		int a[] = {3, 0, 2, 0, 4};
        int a[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int res = 0;
		int left = -1;
		int right =  -1;
		for(int i=1;i<a.length-1;i++){
		  //  find max left
		  int j ;
		      for(j=0;j<i;j++){
		          left = Math.max(left,a[j]);
		      }  
		  // find max right
  		      for(j=i+1;j<a.length-1;j++){
                right = Math.max(left,a[j]);
              }  
              res = res + Math.min(left, right) - a[i];
		}
		System.out.println(res);
	}
}

// This time Complexity is O(n^2)

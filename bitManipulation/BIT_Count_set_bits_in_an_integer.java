// 1st Approach 

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int k = 13;
		int result = 0;
		while (k>0){
    		int f = 1;
		    result+=(k&f);    
    		k = k>>1;
		}
		System.out.println(result);
	}
}

// 2nd Approach

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int k = 13;
		int result = 0;
		while (k>0){
      result++;
      k = k & (k-1);
		}
		System.out.println(result);
	}
}

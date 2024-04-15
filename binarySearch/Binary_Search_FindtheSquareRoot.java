public class Main
{
    static int SquareRoot(int X){
        int low = 0;
		int high = X;
		int ans =0;
		int mid = low + (high-low)/2;
		while(low<=high){
		    if(mid*mid == X){
		        return (int)mid;
		    }
		    if(mid*mid < X){
		        low = mid+1;
		        ans = mid;
		    }else{
		        high = mid-1;
		    }
		}
        return ans;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int X = 4;
		System.out.println(SquareRoot(X));
	}
}

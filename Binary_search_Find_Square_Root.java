
public class Main
{
    static int SquareRoot(int root){
        int x = root;
		int low = 0;
		int high = x;
		int ans = -1;

        if(root==0 || root ==1)
            return root;
		while(low<=high){
		    int mid = low + (high-low)/2;
		    if(mid*mid == x)
		        return mid;
		    if(mid*mid < x){
		        low = mid+1;
		        ans = mid;
		    }else{
		        high = mid-1;
		    }
		}
		return ans;
        
    }
	public static void main(String[] args) {
		System.out.println(SquareRoot(4));
	}
}

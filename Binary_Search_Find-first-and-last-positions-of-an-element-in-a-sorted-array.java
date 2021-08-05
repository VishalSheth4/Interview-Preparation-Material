public class Main
{
	public static void main(String[] args) {
	    int a[] = {1, 3, 5, 5, 5, 5, 7, 123, 125};
	    int k = 5;
	    int high = a.length-1;
	    int low = 0;
        int mid = -1;
        int res = 0;
	    while(low<=high){
    	    mid = low+(high-low)/2;
	        if(a[mid]<k){
	            low=mid+1;
	        }
	        else if(a[mid]>k){
	            high = mid-1;
	        }
	        else{
	            res = mid;
	            high = mid-1;
	        }
	    }
        System.out.println(res);
        res = -1;
        low = 0;
        high = a.length-1;
        while(low<=high){
    	    mid = low+(high-low)/2;
	        if(a[mid]<k){
	            low=mid+1;
	        }
	        else if(a[mid]>k){
	            high = mid-1;
	        }
	        else{
	            res = mid;
	            low = mid+1;
	        }
	    }
        System.out.println(res);
	}
}

// Compare value with index :
// Is such valu and index are same or not

public class Main
{
	public static void main(String[] args) {
	    int a[] = {-10, -5, 0, 3, 7};
	   // int k = 5;
	    int high = a.length-1;
	    int low = 0;
        int mid = -1;
        int res = 0;
	    while(low<high){
    	    mid = low+(high-low)/2;
	        if(a[mid]<mid){
	            low=mid+1;
	        }
	        else if(a[mid]>mid){
	            high = mid-1;
	        }
	        else{
	            res = mid;
	            System.out.println(res);
	            break;
	       //     high = mid-1;
	        }
	    }
        
	}
}

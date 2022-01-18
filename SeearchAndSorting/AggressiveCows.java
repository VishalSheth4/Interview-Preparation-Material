public class Main
{
    static boolean isPossible(int stall[],int gap,int cows){
        int pre=stall[0],c=1;
        for(int i=1;i<stall.length;i++){
            if(stall[i]-pre>=gap){
                pre=stall[i];
                c++;
                if(c==cows){
                    return true;
                }
            }
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int stall[] = {1,2,4,8,9};
		int cows = 3;
		int n = stall.length;
		int low = 0;
		int high = stall[n-1];
		int result = -1;
		while(low<high){
		    int mid=(low+high)/2;
		    if(isPossible(stall,mid,cows)){
                if(result<=mid){
                    result = mid;
                }
                low = mid + 1;
    		}else{
	    	    high = mid;
		    }
		}
		System.out.println(result);
	}
}

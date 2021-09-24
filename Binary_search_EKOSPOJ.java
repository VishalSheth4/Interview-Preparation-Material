public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int result =0;
		int a[] = {20,15,10,17};
		int n = a.length;
		int cutNeeded = 7;
		int max = 0;
		for(int i=0;i<n;i++){
		    max = Math.max(max,a[i]);
		}
		int min=0;
		while(min<=max){
            int mid = (max+min)/2;
            int sum =0;
            for(int i=0;i<n;i++){
                if(a[i]>mid){
                    sum += (a[i]-mid);
                }
            }
            if(sum >= cutNeeded){
                result = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
		}
		System.out.println(result);
	}
}

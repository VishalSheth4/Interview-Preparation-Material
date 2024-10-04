public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int n = 16;
		int diff=0;
		int result=0;
	    int temp = n;
	    while(temp>0){
	        if((temp&1)==1){
	            diff++;
	        }
	        temp = temp >> 1;
	    }
	    if (diff == 1){
	        int pos = 0;
            temp = n;
            while(temp>0){
                pos++;
	            if((temp&1)==1){
	                break;
	            }
	            temp = temp >> 1;
	        }
	        System.out.println(pos);
	    }else{
	        System.out.println(-1);
	    }
	}
}

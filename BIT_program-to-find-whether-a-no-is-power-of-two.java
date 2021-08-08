public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int n = 8;
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
	        System.out.println(n + " is a square root");
	    }else{
            System.out.println(n + " is not a square root");
	    }
	}
}

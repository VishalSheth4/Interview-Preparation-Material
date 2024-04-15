public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int dividend = 10;
		int divisor = 3;
		boolean sign = (dividend>=0) == (divisor >=0) ? true : false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int result = 0;
		
		while(dividend - divisor >= 0){
		    int count = 0;
		    while(dividend - (divisor<<1<<count)>=0){
		        count++;
		    }
		    System.out.println("Count : "+count);
		    result += 1<<count;
		    System.out.println("result : "+result);
		    dividend -= divisor << count;
		}
		
		if(sign){
		    result = result;
		}else{
		    result = -result;
		}
		System.out.println(result);
	}
}

// XOR both elemetns and then the set bis give the difference .

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a = 10;
		int b = 7;
		int sum = a^b;
		int diff = 0;
		while(sum>0){
		    if((sum&1)==1){
		        diff++;
		    }
		sum = sum >> 1;    
		}
		System.out.println(diff);
	}
}

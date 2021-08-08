public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int n = 7;
		int diff=0;
		int result=0;
		for(int i=1;i<=n;i++){
		    int temp = i;
		    while(temp>0){
		        if((temp&1)==1){
		            diff++;
		        }
		        temp = temp >> 1;
		    }
		}
        System.out.println(diff);
	}
}

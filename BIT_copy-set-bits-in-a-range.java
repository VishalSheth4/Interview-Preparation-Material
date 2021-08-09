// B               -  1001 00110 01
// A               -  1010 10101 01

// Create Mask such that only in range index will get 1
// M'              -  0000 11111 00
// M'<<5           -  0000 01000 00
// (M'<<5)-1       -  0000 00111 11
// (M'<<5)-1]<<0   -  0000 11111 00


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int A = 10;
		int B = 13;
		int left = 2;
		int right = 3;
		int output;
        
        if(1<left && right<32){
    		int mask = (1<<(right-left+1));
    		mask--;
    		mask = (mask<< (left-1));
        // 		Now mask created ...
        
            mask = (mask & B);
            mask = (mask | A);
            System.out.println(mask);
        }
	}
}

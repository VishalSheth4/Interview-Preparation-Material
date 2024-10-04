import java.io.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		char set[] = {'a','b','c'};
		int set_size = 3;
		
		long powerSetSize = (long)(Math.pow(2,set_size));
		System.out.println(powerSetSize);
		
		for(int counter=0; counter<powerSetSize; counter++){
		    for(int j=0; j<set_size; j++){
		        if((counter & (1<<j)) > 0){
		            System.out.print(set[j]);
		        }
		        System.out.println("-------");
		    }
		}
	}
}

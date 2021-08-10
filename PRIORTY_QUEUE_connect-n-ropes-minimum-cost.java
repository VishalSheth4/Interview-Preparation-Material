import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {4,3,2,6};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int len = a.length;
		
		for(int i=0;i<len;i++){
		    pq.add(a[i]);
		}
		int result=0;
		while(pq.size()>1){
		    int first = pq.poll();
    	    int second = pq.poll();
    	    
    	    result = result + first + second;
    	    pq.add(first+second);
		}
		
		System.out.println(result);
	}
}


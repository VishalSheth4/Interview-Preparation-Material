import java.util.*;

public class Main
{
    public static Queue<Integer> minHeap,maxHeap;
   
//  Checlist  
  //   isEMPTY
  //   minHeap.peek() > n 
  //   isSIZE()
  
    public static void add(int num) {
            if (!minHeap.isEmpty() && num < minHeap.peek()) {
                maxHeap.offer(num);
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                }
            } else {
                minHeap.offer(num);
                if (minHeap.size() > maxHeap.size() + 1) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }

//   CheckList
  //   Less() than
  //   Greater() than
  //   equal()
  
    public static double getMedian(){
        int median;
        if(minHeap.size()<maxHeap.size()){
            median = maxHeap.size();
        }else if(minHeap.size()>maxHeap.size()){
            median = minHeap.size();
        }else{
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }
	public static void main(String[] args) {
	    minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int a[] = {5,7,3,2,8,10};
        int len = a.length;
        for(int i=0;i<len;i++){
            add(a[i]);
        }
        		System.out.println(minHeap);
        				System.out.println(maxHeap);
        System.out.println(getMedian());
		System.out.println("Hello World");
	}
}

import java.util.*;
public class Main
{
    static void sort(int a[]){
        HashMap<Integer,Integer> count = new HashMap<Integer, Integer>();
        for(int n : a){
            if(count.containsKey(n)){
                count.put(n,count.get(n)+1);
            }else{
                count.put(n,1);
            }
        }
        
        // SORT HashMap
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(count.keySet());
        Collections.sort(sortedKeys);
        for(Integer x : sortedKeys){
            while(count.get(x)>0){
                System.out.print(x+" ");
                count.put(x,count.get(x)-1);
            }
        }
        System.out.println();
    }
    static void printArray(int a[]){
        for(int n : a){
            System.out.print(n+" ");
        }
        System.out.println();
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[] = {100, 12, 100, 1, 1, 12, 100, 1, 12, 100, 1, 1};
		int n=arr.length;
		System.out.println("Input Array");
		printArray(arr);
		
		sort(arr);
	}
}

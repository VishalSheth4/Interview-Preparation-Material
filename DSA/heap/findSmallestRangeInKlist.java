
import java.util.*;

class Node {
    int data;
    int row;
    int col;
    Node(int data, int row, int col)
    {
        this.data = data;
        this.row = row;
        this.col = col;
    }
}

public class Main
{
    public static void findSmallestRange(int arr[][], int k){
        int n = arr.length;
        int max = 0;
        int min = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
        for(int i=0;i<k;i++){
            int data = arr[i][0];
            pq.add(new Node(data, i, 0));
            max=Math.max(max, data);
        }
        
        int range=0;
        int start = 0;
        int end = 0;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            min = temp.data;

            if(range >= max - min){
                range = max - min;
                start = min;
                end = max;
            }

            if(temp.col+1 < n){
                pq.add(new Node(arr[temp.row][temp.col+1], temp.row, temp.col+1));
                max = Math.max(max,arr[temp.row][temp.col+1]);
            }else{
                break;
            }
        }
        System.out.println(min +"   "+max);
        
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[][]
            = { { 1, 3, 5, 7, 9 },
                { 0, 2, 4, 6, 8 },
                { 2, 3, 5, 7, 11 } };
 
        findSmallestRange(arr, 3);
	}
}

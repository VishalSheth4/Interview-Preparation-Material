/******************************************************************************
Important Notes 
Using Min-heap : use sorted LinkedList
        PriorityQueue<Node> pq;
        pq = new PriorityQueue(Comparator.comparingInt(a -> ((Node) a).data));        
        pq.addAll(Arrays.asList(lists).subList(0,lists.length));
*******************************************************************************/

import java.util.*;
public class Main
{
    static class Node{
        int data;
        Node next;
        Node(int n){
            data = n;
            next = null;
        }
    }
    public static Node mergeLists(Node lists[]){
        PriorityQueue<Node> pq;
        pq = new PriorityQueue(Comparator.comparingInt(a -> ((Node) a).data));
        
        pq.addAll(Arrays.asList(lists).subList(0,lists.length));
        
        Node head = null;
        Node tail = null;
        while(!pq.isEmpty()){
            Node min = pq.poll();
            if(head == null){
                head = tail = min;
            }else{
                tail.next = min;
                // tail = min;
                tail = tail.next;
            }
            
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return head;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Node[] lists = new Node[3];
		
		Node l1 = new Node(1);
		l1.next = new Node(5);
		l1.next.next = new Node(7);
		
		Node l2 = new Node(2);
		l2.next = new Node(3);
		l2.next.next = new Node(6);
		l2.next.next.next = new Node(9);	
		
		Node l3 = new Node(4);
		l3.next = new Node(8);
		l3.next.next = new Node(10);
		
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		
		Node temp = mergeLists(lists);
		
		while(temp.next!=null){
		    System.out.println(temp.data);
		    temp = temp.next;
		}
	}
}

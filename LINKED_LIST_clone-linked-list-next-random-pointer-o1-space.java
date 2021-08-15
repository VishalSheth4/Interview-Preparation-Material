/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    public static class Node{
        int data;
        Node next,random;
        Node(int n){
            data = n;
            next = null;
            random = null;
        }
    }
    
    public static void printList(Node start){
        Node temp = start;
        while(temp != null){
            System.out.println("Data = " + temp.data + ", Random = " + temp.random.data);
            temp = temp.next;
        }
    }
    
    public static Node clone(Node start){
        Node curr = start;
        Node temp = null;
        
        // Step-1)  Inserting the node in between every node
        while(curr!=null){
            temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        
        curr = start;
        
        // now adjust the random pointer
        while(curr != null){
            if(curr.next!=null){
                curr.next.random = (curr.random!=null) ? curr.random.next : curr.random;
            }
            curr = curr.next.next;
        }
        //  Next part is important I had done mistake :
        
        Node original = start;
        Node copy = start.next;
        temp = copy;
        
        // step - 3) below steps must be in order....
        while(original!=null){
            original.next = original.next.next;
            copy.next = (copy.next!=null) ? copy.next.next : copy.next;
            copy = copy.next;
            original = original.next;
        }
        return temp;
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);
        
        // 1's random points to 3
        start.random = start.next.next;
 
        // 2's random points to 1
        start.next.random = start;
 
        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
            = start.next.next.next.next;
 
        // 5's random points to 2
        start.next.next.next.next.random = start.next;
 
        System.out.println("Original list : ");
        printList(start);
 
        System.out.println("Cloned list : ");
        Node cloned_list = clone(start);
        printList(cloned_list);
	}
}

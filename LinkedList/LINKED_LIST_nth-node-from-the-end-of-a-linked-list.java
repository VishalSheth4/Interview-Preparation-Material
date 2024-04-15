public class Main
{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next =null;
        }
    }
    
    public static void push(int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    
    public static void printLast(int n){
        if(head == null){
            return ;
        }
        Node first_ptr = head;
        Node second_ptr = head;
        
        for(int i=0;i<n;i++){
            if(first_ptr != null)
            first_ptr = first_ptr.next;
        }
        while(first_ptr!=null){
            second_ptr = second_ptr.next;
            first_ptr = first_ptr.next;
        }
        System.out.println(second_ptr.data);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(20);
		push(10);
		push(4);
		push(15);
		push(35);
		
		printLast(2);
	}
}

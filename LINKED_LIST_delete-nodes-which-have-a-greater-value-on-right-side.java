public class Main
{
    public static class Node{
        int data;
        Node next;
        Node(int n){
            data = n;
            next = null;
        }
    }
    static Node head;
    public static void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static Node deleteNodeOnRightSide(Node head){
        if(head == null || head.next == null) return head;
        Node nextNode = deleteNodeOnRightSide(head.next);
 
        if(nextNode.data > head.data) return nextNode;
        head.next = nextNode;
 
        return head;
    }
    
    public static void push(int data){
        Node new_node = new Node(data);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new_node;
        new_node.next = null;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		head = new Node(1);
		push(12);
		push(15);
		push(10);
		push(11);
		push(5);
		push(6);
		push(2);
		push(3);
		
		printList();
		System.out.println("Before Removing");
		head = deleteNodeOnRightSide(head);
		System.out.println("After Removing");
		printList();
	}
}

public class Main
{
    public static Node head = null;
    public static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    public static void printList()
    {
        if (head != null)
        {
            Node temp = head;
            while (temp != head){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
    
    public static void sortedInsert(Node new_node){
        Node current = head;

        // Case-1 for first time only
        if(current == null){
            new_node.next = new_node;
            head = new_node;
        }
        
        // Case-2 new_node.data > = head.data then go to the previous of head node;
        else if(current.data >= new_node.data){
            while(current.next != head){
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        
        // Case-3 
        else{
            while(current.next != head && current.next.data < new_node.data){
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
            System.out.print(head.data + " ");
        }
        
    }
	public static void main(String[] args) {
	    int arr[] = new int[] {12, 56, 2, 11, 1, 90};
        
        for (int i = 0; i < 6; i++){
            Node temp = new Node(arr[i]);
            sortedInsert(temp);
            printList();
        }
        
	}
}

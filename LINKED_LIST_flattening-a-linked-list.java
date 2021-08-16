public class Main
{
    static Node head;
    public static class Node{
        int data;
        Node right,down;
        Node(int n){
            data = n;
            right = null;
            down = null;
        }
    }
    
    
    public static void printList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }
    
    public static Node push(Node head, int data){
        Node new_node = new Node(data);
        new_node.down = head;
        head = new_node;
        return head;
    }
    public static Node merge(Node a, Node b)
    {
        // if first linked list is empty then second
        // is the answer
        if (a == null)     return b;
 
        // if second linked list is empty then first
        // is the result
        if (b == null)      return a;
 
        // compare the data members of the two linked lists
        // and put the larger one in the result
        Node result;
        if (a.data < b.data){
            result = a;
            result.down =  merge(a.down, b);
        }else{
            result = b;
            result.down = merge(a, b.down);
        }
        result.right = null;
        return result;
    }
    
    public static Node flatten(Node root)
    {
        // Base Cases
        if (root == null || root.right == null)
            return root;
 
        // recur for list on right
        root.right = flatten(root.right);
 
        // now merge
        root = merge(root, root.right);
 
        // return the root
        // it will be in turn merged with its left
        return root;
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		head = push(head,30);
		head = push(head,8);
		head = push(head,7);
		head = push(head,5);
		
		head.right = push(head.right, 20);
        head.right = push(head.right, 10);
 
        head.right.right = push(head.right.right, 50);
        head.right.right = push(head.right.right, 22);
        head.right.right = push(head.right.right, 19);
 
        head.right.right.right = push(head.right.right.right, 45);
        head.right.right.right = push(head.right.right.right, 40);
        head.right.right.right = push(head.right.right.right, 35);
        head.right.right.right = push(head.right.right.right, 20);
		
		head = flatten(head);
		printList();
	}
}

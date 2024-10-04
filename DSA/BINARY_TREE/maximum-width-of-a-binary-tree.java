import java.util.*;
public class Main
{
    public static class Node {
    int data;
    Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    public static void WidthBinaryTree(Node root){
        //  Base Condition
        if(root == null){
            return;
        }
        // Intialization
        int Result = -1;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        // 3 step Manipulation.....
            // if queue is not isEmpty then continue
            // count = queue.size();
            // remove counted elements and add child of remove elements...
            
        while(!q.isEmpty()){
            int count = q.size();
            Result = Math.max(Result,count);
        
            while(count > 0){
                Node temp = q.remove();
                if (temp.left != null)
                {
                    q.add(temp.left);
                }
                if (temp.right != null)
                {
                    q.add(temp.right);
                }
                count--;
            }
        }
        System.out.println(Result);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        WidthBinaryTree(root);
	}
}

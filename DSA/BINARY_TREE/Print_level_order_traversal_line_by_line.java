
import java.util.*;
public class Main
{
    public static Node head = null;
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            data = d;
            left = null;
            right = null;
        }
    }
    
    public static void printLevel(Node root){
        if(root==null){
            return ;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty()){
            int count = q.size();
            while(count > 0){
                Node temp = q.remove();
                System.out.print(temp.data + " ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                count--;
            }
            System.out.println("");
        }
    }
	public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        printLevel(root);
	}
}

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
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
    
    public static Node Mirror(Node root){
        if(root == null){
            return null;
        }
        Node left = Mirror(root.left);
        Node right = Mirror(root.right);
        
        // swap
        root.left= right;
        root.right= left;
        
        return root;
    }
    public static void inOrder(Node node)
        {
            if (node == null)
                return;
     
            inOrder(node.left);
            System.out.print(node.data + " ");
     
            inOrder(node.right);
        }
	public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inOrder(root);
        System.out.println("");
        root = Mirror(root);
        inOrder(root);
        
	}
}

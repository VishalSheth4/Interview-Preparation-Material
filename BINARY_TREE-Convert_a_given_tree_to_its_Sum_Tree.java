/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }
    
    public static int ConvertTreeintoSumTree(Node root){
        if(root == null){
            return 0;
        }
        int old_value = root.data;
        int new_value = ConvertTreeintoSumTree(root.left) + ConvertTreeintoSumTree(root.right);
        
        root.data = new_value;
        return new_value + old_value;
    }
    
    public static void PrintTree(Node root){
        if(root == null){
            return;
        }
        PrintTree(root.left);
        System.out.println(root.data); 
        PrintTree(root.right);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		root.right.left = new Node(7);
		root.right.right = new Node(5);
		
		ConvertTreeintoSumTree(root);
		PrintTree(root);
	}
}

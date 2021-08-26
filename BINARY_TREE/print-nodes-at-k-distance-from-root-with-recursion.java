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
    
    public static void printSameLevelNodeWithRecursion(Node root , int k){
        if(root == null || k<0){
            return ;
        }
        if(k==0){
            System.out.println(root.data+" ");
        }
        printSameLevelNodeWithRecursion(root.left,k-1);
        printSameLevelNodeWithRecursion(root.right,k-1);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		
		int k = 1;
		printSameLevelNodeWithRecursion(root,k);
	}
}

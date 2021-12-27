/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

public class Main
{
    public static void IterativePreOrder(Node root){
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node temp = s.pop();
            System.out.println(temp.data);
            if(temp.right != null){
                s.push(temp.right);
            }
            if(temp.left != null){
                s.push(temp.left);
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		IterativePreOrder(root);
	}
}

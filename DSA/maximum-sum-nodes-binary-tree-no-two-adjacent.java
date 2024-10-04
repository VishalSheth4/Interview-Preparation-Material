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
    public static int maxSum(Node root){
        HashMap<Node,Integer> hmap = new HashMap<>();
        if(root==null){ return 0; }
        if(hmap.containsKey(root)){ return hmap.get(root); }
        int incl = root.data;
        if(root.left!=null){
            incl += maxSum(root.left.left) + maxSum(root.left.right);
        }
        if(root.right!=null){
            incl += maxSum(root.right.left) + maxSum(root.right.right);
        }
        
        int excl = maxSum(root.left) + maxSum(root.right);
        hmap.put(root,Math.max(incl,excl));
        return hmap.get(root);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root= new Node(10); 
        root.left= new Node(1); 
        root.left.left= new Node(2); 
        root.left.left.left= new Node(1); 
        root.left.right= new Node(3); 
        root.left.right.left= new Node(4); 
        root.left.right.right= new Node(5); 
        System.out.print(maxSum(root)); 
	}
}

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

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
    static void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    static Node deleteLeaves(Node root, int x)
    {
        // Base condition
        if (root == null)
            return null;
            
        // Hypothesis
        root.left = deleteLeaves(root.left, x);
        root.right = deleteLeaves(root.right, x);
     
        // Manipulation work  
        if (root.data == x && root.left == null && root.right == null) {
     
            return null;
        }
        return root;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(6);
		root.left = new Node(5);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.right = new Node(5);
		
		int k = 5;
		deleteLeaves(root,k);
		inorder(root);
		
	}
}

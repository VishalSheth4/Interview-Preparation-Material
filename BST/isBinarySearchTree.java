/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
class Node
{
    int data;
    Node left = null, right = null;
    Node(int data) {
        this.data = data;
    }
}
public class Main
{
    public static Node insert(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if(key>=root.data){
            root.right = insert(root.right,key);
        }else{
            root.left = insert(root.left,key);
        }
        return root;
    }
    
    public static boolean isBST(Node node, int minKey, int maxKey)
    {
        // base case
        if (node == null) {
            return true;
        }
 
        // if the node's value falls outside the valid range
        if (node.data < minKey || node.data > maxKey) {
            return false;
        }
 
        // recursively check left and right subtrees with an updated range
        return isBST(node.left, minKey, node.data) && isBST(node.right, node.data, maxKey);
    }
    public static void isBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("The tree is a BST.");
        }
        else {
            System.out.println("The tree is not a BST!");
        }
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
        isBST(root);
	}
}

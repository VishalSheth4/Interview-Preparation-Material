
import java.util.*;
class Node{
    int data;
    Node left = null;
    Node right = null;
    Node(int d){
        this.data = d;
    }
}
public class Main
{
    static void printInorder(Node root){
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }
    static int index;
    static void storeInorder(Node node, int inorder[]){
        if (node == null)
            return;
        storeInorder(node.left, inorder);
        inorder[index] = node.data;
        index++;
        storeInorder(node.right,inorder);
    }
    
    static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    static void arrayToBST(int[] arr, Node root)
    {
        if (root == null)
            return;
        arrayToBST(arr, root.left);
        root.data = arr[index];
        index++;
        arrayToBST(arr, root.right);
    }
    
    static void binaryTreeToBST(Node root){
        if(root==null){
            return;
        }
        int n = countNodes(root);
        int arr[] = new int[n];
        storeInorder(root,arr);
        Arrays.sort(arr);
        index = 0;
        arrayToBST(arr, root);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.right.right = new Node(5);
		
		binaryTreeToBST(root);
		System.out.println("-------------");
		printInorder(root);
	}
}

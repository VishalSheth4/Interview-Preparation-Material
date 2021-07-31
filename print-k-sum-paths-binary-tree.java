// print-k-sum-paths-binary-tree
// Use preOrder Approach...

import java.util.*;
public class Main
{
    static Vector<Integer> path = new Vector<Integer>();
    static class Node
    {
        int data;
        Node left,right;
        Node(int x)
        {
            data = x;
            left = right = null;
        }
    };
    
    public static void printPath(Vector path, int i){
        for(int j=i;j<path.size();j++){
            System.out.print(path.get(j)+", ");
        }
        System.out.println();
    }
    public static void printKPathUtil(Node root, int k){
        if(root == null){
            return; 
        }
        path.add(root.data);
        printKPathUtil(root.left,k);
        printKPathUtil(root.right,k);
        int f = 0;
        for(int i = path.size()-1;i>=0;i--){
            f = f + path.get(i);
            if(f == k){
                printPath(path,i);
            } 
        }
        path.remove(path.size() - 1);
    }
    public static void printKPath(Node root, int k){
        path = new Vector<Integer>();
        printKPathUtil(root,k);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
        int k = 5;
        printKPath(root, k);
	}
}

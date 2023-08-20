//Count BST nodes that lie in a given range

import java.util.*;
public class Main{
    static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data=data;
            left = right = null;
        }
    }
    
    Node root;
    
    Main(){
        root = null;
    }
    
    int getCount(Node node, int low, int high){
        if (node == null){
            return 0;
        }
        if(node.data >= low && node.data <=high){
            return 1 + this.getCount(node.left,low,high) + this.getCount(node.right,low,high); 
        }else if(node.data < low ){
            return this.getCount(node.right, low, high);
        }else{
            return this.getCount(node.left, low, high);
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Main tree = new Main();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(50);
		tree.root.left.left = new Node(1);
		tree.root.right.left = new Node(40);
		tree.root.right.right = new Node(100);
		
		int low=5;
		int high=45;
		System.out.println(tree.getCount(tree.root,low,high));
	}
}
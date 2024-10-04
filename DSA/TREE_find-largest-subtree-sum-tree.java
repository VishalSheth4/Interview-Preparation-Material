import java.util.*;
public class Main
{
    // static int ans = Integer.MAX_VALUE;
    
    public static class Node{
        int data;
        Node left, right;
        Node(int n){
            data = n;
            left = null;
            right = null;
        }
    }
    public static class INT{
        int ans;
        INT(int data){
            ans = data;
        }
    }
    public static int findLargestSubtreeUtil(Node root, INT i){
        if(root == null){
            return 0;
        }
        int currSum = root.data + findLargestSubtreeUtil(root.left,i) + findLargestSubtreeUtil(root.right,i);
        i.ans = Math.max(i.ans, currSum);
        return currSum;
    }
    
    public static int findLargestSubtree(Node root){
        // Base condition
        if(root == null){
            return 0;
        }
        INT i = new INT(-9999999);
        findLargestSubtreeUtil(root,i);
        return i.ans;
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Node root = new Node(1);
		root.left = new Node(-2);
		root.right = new Node(3);
		root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);
        System.out.println(findLargestSubtree(root));
	}
}

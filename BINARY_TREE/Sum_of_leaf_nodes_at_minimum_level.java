
// Find sum of minimum level leaf Node
// 1 step ) traverse each level
//  2) when get leaf at some level that elvel is minimum. 


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
    public static int findMinimumLevelSum(Node root){
        int sum =0;
        Queue<Node> q = new LinkedList<Node>();
        
        if (root == null){
            return -1;
        }
        if(root.left == null && root.right ==null){
            return root.data;
        }
        q.add(root);
        int flag = 0;
        while(flag==0){
            int nodecount = q.size();
            // System.out.println(nodecount);
            while(nodecount-- > 0){
                Node top = q.peek();
                 q.poll();
                // q.remove();
                
                if(top.left == null && top.right == null){
                    sum = sum + top.data;
                    flag = 1;
                }else{
                    if (top.left != null)
                        q.add(top.left);
                    if (top.right != null)
                        q.add(top.right);
                }
            }
        }
        return sum;
    }
	public static void main(String[] args) {
	    Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.left.right.left = new Node(8);
	    root.right.left.right = new Node(9);
	    System.out.println(findMinimumLevelSum(root));
	}
}

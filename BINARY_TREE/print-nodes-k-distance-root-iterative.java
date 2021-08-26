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
    public static void printSameLevelNode(Node root , int kLevel){
        Queue<Node> q = new LinkedList<>();
        boolean flag = false;
        int level = 1;
        q.add(root);
        q.add(null);
        
        // 3 condtion to be checked
        // null is to difeeniate levels
        // 1) get first value (temp) from Queue.
        // 2) print only when (level == kLevel && temp != null)
        // 3) temp == null ? add null; level++;  :else: add left and right node in queue.  
        // level > kLevel ? break
        
        while(q.size()>0){
            Node temp = q.peek();
            if(level == kLevel && temp != null){
                flag = true;
                System.out.println(temp.data+" ");
            }
            q.remove();
            if(temp == null){
                if(q.peek() != null){
                    q.add(null);
                }
                level++;
                if (level > kLevel){
                    break;
                }
            }else{
                if (temp.left != null)
                q.add(temp.left);
 
            if (temp.right != null)
                q.add(temp.right);
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		
		int k = 2;
		printSameLevelNode(root,k);
// 		inorder(root);
		
	}
}

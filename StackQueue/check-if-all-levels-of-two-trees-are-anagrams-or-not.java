/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    static class Node{
        Node left , right;
        int data;
        Node(int d){
            this.data=d;
            left=right=null;
        }
    }
    
    public static boolean areAnagrams(Node r1 , Node r2){
        if(r1==null && r2==null){
            return true;
        }
        if(r1==null || r2==null){
            return false;
        }
        
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        q1.add(r1);
        q2.add(r2);
        
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        while(!q1.isEmpty() && !q2.isEmpty()){
            // Size 
            int n1=q1.size();
            int n2=q2.size();
            
            if(n1!=n2){ return false; }
            
            if(n1==0){ break; }
            
            while(n1-- > 0){
                Node node1 = q1.peek();
                q1.remove();
                m.put(node1.data,m.getOrDefault(node1.data,0)+1);
                if(node1.left != null){
                    q1.add(node1.left);
                }
                if(node1.right != null){
                    q1.add(node1.right);
                }
            }
            System.out.println(m);
            while(n2-- > 0){
                Node node2 = q2.peek();
                q2.remove();
                if(!m.containsKey(node2.data)){
                    return false;
                }
                m.put(node2.data,m.get(node2.data)-1);
                
                if(m.get(node2.data)==0){
                    m.remove(node2.data);
                }
                
                if(node2.left != null){
                    q2.add(node2.left);
                }
                if(node2.right != null){
                    q2.add(node2.right);
                }
            }
            if(m.size()>0){
                return false;
            }
        }
        if (q1.isEmpty() && q2.isEmpty())
            return true;
        return false;
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root1= new Node(1);
		root1.left = new Node(3);
		root1.right = new Node(2);
		root1.right.left = new Node(5);
		root1.right.right = new Node(4);
		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		
		if (areAnagrams(root1, root2))
            System.out.println("Yes");
        else
            System.out.println("No");
	}
}

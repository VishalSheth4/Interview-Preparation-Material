    class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }
public class Main{

    public static Node Lca(Node root, int n1, int n2){
        if(root == null)
            return root;
        if(root.data == n1 || root.data == n2){
            return root;
        }
        Node left = Lca(root.left,n1,n2);
        Node right = Lca(root.right,n1,n2);        
        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        if (left != null)
            return Lca(root.left, n1, n2);
        else
            return Lca(root.right, n1, n2);
    }
    
    public static int findLevel(Node root, int n, int level){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return level;
        }
        int left = findLevel(root.left,n,level+1);
        if(left == -1){
            return findLevel(root.right,n,level+1);
        }
        return left;
    }
    public static int findDistance(Node root, int n1, int n2){
        Node LCA = Lca(root, n1, n2);
        int d1 = findLevel(LCA, n1, 0);
        int d2 = findLevel(LCA, n2, 0);
        System.out.println(d2);
        return d1 + d2;
        
    }
	public static void main(String[] args) {
	    Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
	    
	    System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
	}
}

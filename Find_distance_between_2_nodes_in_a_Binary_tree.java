public class Main
{
    public static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    public static Node LCA(Node root, int n1, int n2){
        if (root == null){
            return null;
        }
        // if(root.data > n1 && root.data > n2){
        //     return LCA(root.left,n1,n2);
        // }
        // if(root.data < n1 && root.data < n2){
        //     return LCA(root.right,n1,n2);
        // }
        if (root.data == n1 || root.data == n2){
            return root;
        }
        Node lca_left = LCA(root.left,  n1, n2);
        Node lca_right = LCA(root.right,  n1, n2);
        
        if(lca_left!=null && lca_right!=null){
            return root;
        }
        return (lca_left!=null)?lca_left:lca_right;
    }
    public static int findLevel(Node root, int n, int level){
        int dist=-1;
        if(root == null){
            return -1;
        }
        if(root.data==n){
            return dist;
        }
        dist = findLevel(root.left,n+1);
        return (dist!=-1)?dist:findLevel(root.right,n+1);
    }
    public static int Finddistance(Node root, int n1,int n2){
        Node lca = LCA(root,n1,n2);
        
        int d1 = findLevel(lca,n1);
        int d2 = findLevel(lca,n2);
        
        return d1 + d2;
    }
	public static void main(String[] args) {
	    Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        int n1 = 14;
        int n2 = 10;
        Finddistance(root,n1,n2);
		System.out.println( " _ " + Finddistance(root,n1,n2));
	}
}

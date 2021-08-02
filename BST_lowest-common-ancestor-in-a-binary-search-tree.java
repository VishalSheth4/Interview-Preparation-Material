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
        if(root.data > n1 && root.data > n2){
            return LCA(root.left,n1,n2);
        }
        if(root.data < n1 && root.data < n2){
            return LCA(root.right,n1,n2);
        }
        return root;
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
		System.out.println( " _ " + LCA(root, n1, n2).data);
	}
}
  

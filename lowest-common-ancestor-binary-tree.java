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
//       if not found then null  
      if (root == null){
            return null;
        }
//   If need to convert into the LCA in BST .....     
        // if(root.data > n1 && root.data > n2){
        //     return LCA(root.left,n1,n2);
        // }
        // if(root.data < n1 && root.data < n2){
        //     return LCA(root.right,n1,n2);
        // }
      
//    If found any of side. one or two..(EXIT Condition)..   
        if (root.data == n1 || root.data == n2){
            return root;
        }
//       Hypothesis find on both side....
        Node lca_left = LCA(root.left,  n1, n2);
        Node lca_right = LCA(root.right,  n1, n2);
        
//       if both found then return lca node .....
        if(lca_left!=null && lca_right!=null){
            return root;
        }
//       If any one of found then return lca node
        return (lca_left!=null)?lca_left:lca_right;
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

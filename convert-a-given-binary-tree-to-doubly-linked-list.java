public class Main
{
    public static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }
    
    // 3 Case to be checked
    // go for max depth left then linked to Left.right = node ; && node.left = Left ;
    // go for max depth right then linked to Right.left = node && node.right = Right;
    
    public static Node binaryTreeToDLLUtils(Node root){
        if(root == null){
            return root;
        }
        if(root.left != null){
            Node Left = binaryTreeToDLLUtils(root.left);
            while(Left.right != null){
                Left = Left.right;
            }
            Left.right = root;
            root.left = Left;
            
        }
        if(root.right != null){
            Node Right = binaryTreeToDLLUtils(root.right);
            while(Right.right != null){
                Right = Right.right;
            }
            for (; Right.left != null; Right = Right.left);
            Right.left = root;
            root.right = Right;
            
        }
        return root;
    }
    public static void binaryTreeToDLL(Node root){
        if(root == null){
            return ;
        }
        Node temp = binaryTreeToDLLUtils(root);
        // print DLL
        while(temp.left!=null){
            temp = temp.left;
        }
        while(temp.right != null)
        {
            System.out.println(temp.data);
            temp = temp.right;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);
		
		binaryTreeToDLL(root);
	}
}

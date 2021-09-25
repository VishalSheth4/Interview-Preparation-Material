public class Main
{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data = d;
            left = null;
            right =null;
        }
    }
    static Node root;
    static Node insert(Node root, int data){
        if(root==null){
            root = new Node(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right,data);
        }
        return root;
    }
    
    static Node search(Node root, int key){
        if(root == null || root.data == key){
            return root;
        }
        if(root.data > key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }
    
    static void inorderPrint(Node root){
        if(root!=null){
            inorderPrint(root.left);
            System.out.println(root.data);
            inorderPrint(root.right);
        }
    }
	public static void main(String[] args) {
	    root = insert(root,50);
	    root = insert(root,30);
	    root = insert(root,20);
	    root = insert(root,40);
	    root = insert(root,70);
	    root = insert(root,60);
	    root = insert(root,80);
	    inorderPrint(root);
	    
	    Node temp = search(root,40);
	    System.out.println("Hello World");
	    
	    System.out.println(temp.data);
	}
}

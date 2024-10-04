/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
class Node{
    int data;
    Node left=null;
    Node right=null;
    Node(int d){
        this.data = d;
    }
}
class Index {
    int index = 0;
}
public class Main
{
    Index index = new Index();
    Node constructTreeUtil(int pre[], Index preIndex,
                           int key, int min, int max,
                           int size){

        if (preIndex.index >= size) {
            return null;
        }
 
        Node root = null;

        if (key > min && key < max) {
            root = new Node(key);
            preIndex.index = preIndex.index + 1;
 
            if (preIndex.index < size) {
                root.left = constructTreeUtil(
                    pre, preIndex, pre[preIndex.index], min,
                    key, size);
            }
            if (preIndex.index < size) {
                root.right = constructTreeUtil(
                    pre, preIndex, pre[preIndex.index], key,
                    max, size);
            }
        }
 
        return root;
    }
    
    Node constructTree(int pre[], int size){
        int preIndex=0;
        return constructTreeUtil(pre,index,pre[0],Integer.MIN_VALUE,Integer.MAX_VALUE,size);
    }
    void printInorder(Node node)
    {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {10,5,1,7,40,50};
		int n = a.length;
		Main m = new Main();
        Node node = m.constructTree(a,n);
        m.printInorder(node);
	}
}

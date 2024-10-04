/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static class Node{
        int data;
        Node next;
        Node prev;
    }
    
    static void printList(Node node)
    {
        Node last;
        while (node != null)
        {
            System.out.print( node.data + " ");
            last = node;
            node = node.next;
        }
    }
    static Node append(Node head, int data){
        System.out.println("Entering into Append");
        Node newNode = new Node();
        Node last = head;
        newNode.data=data;
        newNode.next=null;
        if(head==null){
            newNode.prev=null;
            head=newNode;
            return head;
        }
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    
        return head;
    }
    
    static Node mergeList(Node l1, Node l2){
        Node s=null;
        // If any one LL is null then return other LL.
        if(l1==null || l2==null){
            return(l1==null ? l2 : l1);
        }

        // Set head pointer to small element.        
        if(l1.data < l2.data){
            l1.prev=s;
            s=l1;
            l1=l1.next;
        }else{
            l2.prev=s;
            s=l2;
            l2=l2.next;
        }
        Node head = s;
        
        // Merge each node into finaList list
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                s.next=l1;
                l1.prev=s;
                s=s.next;
                l1=l1.next;
            }else{
                s.next=l2;
                l2.prev=s;
                s=s.next;
                l2=l2.next;
            }
        }
        
        // Merge rest LL.
        if(l1 == null){
            s.next=l2;
            l2.prev=s;
        }
        if(l2 == null){
            s.next=l1;
            l1.prev=s;
        }
        return head;
    }
    
    static Node mergeAllList(Node head[], int k){
        Node finalList = null;
        for(int i=0;i<k;i++){
            System.out.println("Entering into Merge");
            finalList = mergeList(finalList, head[i]);
            System.out.println("merge list " + i);
        }
        return finalList;
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		int k=3;
		Node head[] = new Node[k];
		for(int i=0;i<k;i++){
		    head[i]=null;
		}
		head[0]=append(head[0],1);
		head[0]=append(head[0],5);
		head[0]=append(head[0],9);
		
		printList(head[0]);
		
		head[1]=append(head[1],2);
		head[1]=append(head[1],3);
		head[1]=append(head[1],7);
		head[1]=append(head[1],12);
		
		printList(head[1]);
		
		head[2]=append(head[2],8);
		head[2]=append(head[2],11);
		head[2]=append(head[2],13);
		head[2]=append(head[2],18);
		
		printList(head[2]);
		
		System.out.println("Entering in MergeAllList");
		Node finalList = mergeAllList(head, k);
		printList(finalList);
	}
}

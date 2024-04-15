import java.util.*;
public class Main
{
    static Node head;
    public static class Node{
        int data;
        Node next;
        Node(int n){
            data = n;
            next = null;
        }
        
    }
    
    public static void push(int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    
    public static void printList(){
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void segregateOddandEven(){
        Node end = head;
        Node prev = null;
        Node curr = head;
        
        /* Get pointer to last Node */
        while (end.next != null)
            end = end.next;
            
        Node new_end = end;
        
        while (curr.data %2 !=0 && curr != end)
        {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }    
        
        // do following steps only if there is an even node
        if (curr.data %2 ==0)
        {
            head = curr;
 
            // now curr points to first even node
            while (curr != end)
            {
                if (curr.data % 2 == 0)
                {
                    prev = curr;
                    curr = curr.next;
                }
                else
                {
                    /* Break the link between prev and curr*/
                    prev.next = curr.next;
 
                    /* Make next of curr as null */
                    curr.next = null;
 
                    /*Move curr to end */
                    new_end.next = curr;
 
                    /*Make curr as new end of list */
                    new_end = curr;
 
                    /*Update curr pointer */
                    curr = prev.next;
                }
            }
        }
    }
        public static void main(String[] args) {
                System.out.println("Hello World");
                push(11);
        push(10);
        push(9);
        push(8);
        push(7);
        push(6);
        push(3);
        push(4);
        push(2);
        push(0);
        System.out.println("Origional Linked List");
        printList();
        
        segregateOddandEven();

        System.out.println("After segregate Linked List");
        printList();
        
        }
}

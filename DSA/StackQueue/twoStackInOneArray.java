package StackQueue;

public class twoStackInOneArray {
	class twoStacks
	{
	    int a[];
	    int size;
	    int top1, top2;
	    twoStacks()
	    {
	        size = 100; 
	        a = new int[100]; 
	        top1 = -1; 
	        top2 = size;
	    }
	    //Function to push an integer into the stack1.
	    void push1(int x){
	        a[++top1]=x;
	    }
	    //Function to push an integer into the stack2.
	    void push2(int x)
	    {
	       a[--top2]=x;
	    }
	    //Function to remove an element from top of the stack1.
	    int pop1() { 
	        if (top1 >= 0) { 
	            int x = a[top1]; 
	            top1--; 
	            return x; 
	        } 
	        else {
	            return -1;
	        } 
	    }
	    //Function to remove an element from top of the stack2.
	    int pop2(){ 
	        if (top2 < size) { 
	            int x = a[top2]; 
	            top2++; 
	            return x; 
	        } 
	        else { 
	            return -1;
	        } 
	    }
	}


}

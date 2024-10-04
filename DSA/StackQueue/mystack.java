//implement stack from Scratch 

package StackQueue;
public class mystack {
	private int max;
	private int[] a;
	private int top;
	public mystack(int n ) {
		max = n;
		a = new int[max];
		top = -1;
	}
	public void push(int n) {
			a[++top]=n;
	}
	public int pop() {
		return a[top--];
	}
	public int peep() {
		return a[top];
	}
	public boolean isEmpty() {
		return (top==-1);
	}
	public boolean isFull() {
		return top==max-1;
	}
	public static void main(String args[]) {
		mystack thestack = new mystack(10);
		thestack.push(10);
		thestack.push(20);	
		thestack.push(30);	
		thestack.push(40);	
		thestack.push(50);
		while(!thestack.isEmpty()) {
			int value = thestack.pop();
			System.out.println(value);
		}
	}
}

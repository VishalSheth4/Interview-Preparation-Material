package StackQueue;

public class myQueue {
	private int front;
	private int rear;
	private int size;
	private int capacity;
	private int[] a;
	
	public myQueue(int n) {
		capacity = n;
		front = size = 0;
		rear = capacity - 1;
		a = new int[capacity];
	}
	public boolean isFull() {
		return (capacity == size);
	}
	public boolean isEmpty() {
		return (size == 0);
	}
	public void enqueue(int n){
		if(isFull()) {
			return;
		}
		rear = (rear+1)%capacity;
		a[rear] = n;
		size++;
		System.out.println("Enqueue to dequeued");
	}
	public int dequeue() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int item = a[front];
		front = (front-1)%capacity;
		size--;
		return item;
		
	}
	public static void main(String args[]) {
		myQueue myqueue = new myQueue(10);
		myqueue.enqueue(10);
		myqueue.enqueue(20);
		myqueue.enqueue(30);
		myqueue.enqueue(40);
		
		System.out.print("FRONT "+myqueue.front);
		
		System.out.print("REAR "+myqueue.rear);
		
		System.out.println(myqueue.dequeue());
	}
}

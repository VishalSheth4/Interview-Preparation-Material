package StackQueue;

import java.util.*;
public class reverse_a_stack_using_recursion {

	public static Stack<Integer> st = new Stack<>();

	public static void insert_at_bottom(Integer x) {
		if(st.isEmpty()) {
			st.push(x);
		}else {
			Integer a = st.peek();
			st.pop();
			insert_at_bottom(x);
			st.push(a);
		}
	}
	public static void reverse() {
		if(st.size()>0) {
			Integer x=st.peek();
			st.pop();
			reverse();
			insert_at_bottom(x);
		}
	}
	public static void main(String args[]) {

		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		reverse();
		System.out.println(st);
	}
}

package StackQueue;

import java.util.*;
public class Implement_a_method_to_insert_an_element_at_its_bottom_without_using_any_other_data_structure {
	public static Stack<Character> st = new Stack<>();
	static void insert_at_bottom(char x){
	    if(st.isEmpty()) {
	        st.push(x);
	        return;
	    }
	    else{
	        char a = st.peek();
	        st.pop();
	        insert_at_bottom(x);
	        st.push(a);
	    }
	}
	public static void main(String args[]) {
		st.push('a');
		st.push('b');
		st.push('c');
		st.push('d');
		insert_at_bottom('e');
		while (st.size() > 0) {
            System.out.print(st.peek() + " ");
            st.pop();
        }
	}
}

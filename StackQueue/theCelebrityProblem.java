package StackQueue;

import java.util.*;
public class theCelebrityProblem {
	static int MATRIX[][] = { 
			{ 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };
	
	public static int knows(int first, int second) {
		if(MATRIX[first][second]==1) {
			return second;
		}else {
			return first;
		}
	}
	public static void main(String args[]) {
		Stack<Integer> st = new Stack<>();
		int n=MATRIX.length;
		for(int i=0;i<n;i++) {
			st.push(i);
		}
		while(st.size()>1) {
			int first=st.pop();
			int second=st.pop();
			int addTemp=knows(first,second);
			st.push(addTemp);
		}
		int c=st.pop();
		System.out.print(c);
//		for (int i = 0; i < n; i++) {
//            // If any person doesn't know 'c' or 'a' doesn't
//            // know any person, return -1
//            if (i != c && (knows(c, i) || (!knows(i, c)))) {
//            	
//            }
//        }
	}
}

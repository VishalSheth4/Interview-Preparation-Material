// Kindly look into the snippet in the directory for questions

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String s) {
        int counter_block = 1;
		int block_length=1;
		int over_block_length=0;
		int len = s.length();
		for(int i=0;i<len-1;i++){
		    if(s.charAt(i)!=s.charAt(i+1)){
		        counter_block++;
		        block_length=1;
		    }else{
		        block_length++;
		    }
		    over_block_length = Math.max(over_block_length,block_length);
		}
// 		Now geing max length of block 
        int each_block_length = 1;
        int result =0;
		for(int i=0;i<len-1;i++){
		    if(s.charAt(i)==s.charAt(i+1)){
		        each_block_length++;
		    }else{
		        result = result + over_block_length - each_block_length;
		        each_block_length = 1;
		    }
		}
		result = result + over_block_length - each_block_length;
        return result;
    }
}

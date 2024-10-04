import java.util.*;

public class Main
{
    final static int MAX_CHAR=26;
    static void firstNonRepeating(String str){
        int[] charCount = new int[MAX_CHAR];
        Queue<Character> q = new LinkedList<Character>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            
            charCount[ch - 'a']++;
            
            // check for the firstNonRepeating character.
            
            while(!q.isEmpty()){
                if(charCount[q.peek() - 'a'] > 1){
                    q.remove();
                }else{
                    System.out.println(q.peek() + "");
                    break;
                }                
            }
            if(q.isEmpty()){
                System.out.println(-1 + "");
            }
        }
        System.out.println();
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "aabc";
		firstNonRepeating(str);
	}
}

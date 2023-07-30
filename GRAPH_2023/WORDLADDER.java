/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class WORDLADDER
{
    static int shortestChainLen(String start,String target,Set<String> D){
        // corner cases 
        if(start == target)
            return 0;
            
        if (!D.contains(target))
            return 0;
        
        int level=0;
        int wordlength=start.length();
        Queue<String> Q = new LinkedList<>();
        Q.add(start);
        while(!Q.isEmpty()){
            ++level;
            int sizeofQ=Q.size();
            for(int i=0;i<sizeofQ;i++){
                System.out.println(sizeofQ);
                System.out.println(Q);
                char word[] = Q.peek().toCharArray();
                Q.remove();
                System.out.println(Q);
                for(int pos=0;pos<wordlength;pos++){
                    char orig_char=word[pos];
                    for(char c='a';c<='z';c++){
                        word[pos]=c;
                        if(String.valueOf(word).equals(target))
                            return level+1;
                        
                        if(!D.contains(String.valueOf(word)))
                            continue;
                        D.remove(String.valueOf(word));
                        Q.add(String.valueOf(word));
                    }
                    System.out.println(Q);
                    word[pos] = orig_char;
                }
            }
        }

        return 0;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		// make dictionary
        Set<String> D = new HashSet<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: " + shortestChainLen(start, target, D));
	}
}

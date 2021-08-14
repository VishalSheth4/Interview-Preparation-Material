import java.util.*;
public class Main
{
    public static void findFirstNonRepeating(String stream){
        final int MAX_CHAR = 256;
        List<Character> inDLL = new ArrayList<Character>();
        boolean[] repeated = new boolean[MAX_CHAR];
        for(int index=0;index<stream.length();index++){
            char x = stream.charAt(index);
            System.out.println("Reading "+x);
            if(!repeated[x]){
                if(!(inDLL.contains(x))){
                    inDLL.add(x);                    
                }else{
                    inDLL.remove((Character)x);
                    repeated[x] = true;    
                }
            }
            if (inDLL.size() != 0) {
                System.out.print("First non-repeating character so far is ");
                System.out.println(inDLL.get(0));
            }
        }
        
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String stream = "geeksforgeeksandgeeksquizfor";
		findFirstNonRepeating(stream);
	}
}

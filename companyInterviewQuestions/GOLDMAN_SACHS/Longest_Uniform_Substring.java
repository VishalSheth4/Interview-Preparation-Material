import java.util.*;
public class Main
{
	public static void main(String[] args) {
//     3 test case checked -----
// 		String str = "aabbbbbCdAA";
//    String str = "10000111";
      String str = "aabbbcc";
    
		int index = 0;
		int lengthof = 0;
		Map<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
		    if(hm.containsKey(str.charAt(i))){
		        hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
		    }else{
		        hm.put(str.charAt(i),0);
		    }
		    if(hm.size()>1){
		        if(lengthof < hm.get(str.charAt(i-1))){
		            lengthof = hm.get(str.charAt(i-1));
		           index = i-lengthof-1;
		        }
		        i--;
		        hm.clear();
		    }
		}
    System.out.println(index);
	}
}

// Word Break Problem
// everytime check in dicotnary whether the prefix word is present or not...

import java.util.*;
public class Main
{
    public static String dictonary[] = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};
	public static Set<String> s = new HashSet<>();
    public static boolean wordWrap(String ans){
        int size = ans.length();
        if(size == 0){
            return true;
        }
        for(int i=0;i<=size;i++){
            System.out.println(ans.substring(0,i));
            if (s.contains(ans.substring(0,i)) && wordWrap(ans.substring(i,size))){
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String ans = "ilikesamsung";
		for( String temp : dictonary){
		    s.add(temp);
		}
		System.out.println(wordWrap(ans));
	}
}

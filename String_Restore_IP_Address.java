import java.util.*;
public class Main
{
    public static boolean isValid(String s){
        if(s.charAt(0)=='0'){
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num<=255 && num>0;
    }
    public static void dfs(String s, String res, ArrayList<String> result,int section){
        if(section==4 && isValid(s)){
            result.add(res+s);
            return;
        }
        for(int i=1;i<4 && i<s.length();i++){
            String substr = s.substring(0,i);
            if(isValid(substr)){
                dfs(s.substring(i),res+substr+'.',result,section+1);                
            }
        }
    }
    public static ArrayList<String> restoreIpAddresses(String s){
        ArrayList<String> result = new ArrayList<>();
        if(s.length() >=4 && s.length() <=12){
            dfs(s,"",result,1);
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String a = "25525511135";
        for(String s : restoreIpAddresses(a)){
            System.out.println(s);
        }
	}
}

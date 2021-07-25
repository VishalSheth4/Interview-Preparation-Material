// Pick and Don't pick approach 

public class Main
{
    public static void subsequence(String s, String ans, int n){
        if(s.length()==0){
            System.out.println(ans);
        }else{
            subsequence(s.substring(1),ans+s.charAt(0),n);
            subsequence(s.substring(1),ans,n);
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String s = "abcd";
		String ans = "";
		int length = s.length();
		int i = 0;
		subsequence(s,ans,length);
	}
}

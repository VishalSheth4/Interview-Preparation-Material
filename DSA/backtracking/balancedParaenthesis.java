import java.util.*;


public class Main
{
    public static void balancedParaenthesisUtil(int n, String ans, int openBracket, int CloseBracket ){
        if(CloseBracket > openBracket || openBracket > n){
            return;
        }
        if(CloseBracket >= n){
            System.out.println(ans);
            return;
        }

        balancedParaenthesisUtil(n, ans + "{" +" ",openBracket+1,CloseBracket);
        balancedParaenthesisUtil(n, ans + "}" +" ",openBracket,CloseBracket+1);
    }
    public static void balancedParaenthesis(int n){
        balancedParaenthesisUtil(n, "", 0, 0);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int n = 3;
		balancedParaenthesis(n);
	}
}

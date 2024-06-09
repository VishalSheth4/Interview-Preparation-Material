
public class Main
{
    static boolean isValidString(String str)
{
    int cnt = 0;
    for (int i = 0; i < str.length(); i++)
    {
        if (str.charAt(i) == '(')
            cnt++;
        else if (str.charAt(i) == ')')
            cnt--;
        if (cnt < 0)
            return false;
    }
    return (cnt == 0);
}
    public static void RemoveInvalidParenthesisUtil(String str, int totalLength, int currentIndex, String ans){
        if(currentIndex>=totalLength){
            if(isValidString(ans)){
                System.out.println(ans);
            }
            return;
        }

        if(str.charAt(currentIndex)=='('){
            RemoveInvalidParenthesisUtil(str,totalLength,currentIndex+1,ans+"(");
        }
        if(str.charAt(currentIndex)==')'){
            RemoveInvalidParenthesisUtil(str,totalLength,currentIndex+1,ans+")");
            RemoveInvalidParenthesisUtil(str,totalLength,currentIndex+1,ans);
        }
    }
    public static void RemoveInvalidParenthesis(String str){
        int totalLength=str.length();
        int currentIndex=0;
        RemoveInvalidParenthesisUtil(str,totalLength,currentIndex,"");
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "()())()";
        // Output : ()()() (())()
        // There are two possible solutions
        // "()()()" and "(())()"
        // String str1 = (v)())();
        // Output : (v)()()  (v())()
        RemoveInvalidParenthesis(str);
	}
}

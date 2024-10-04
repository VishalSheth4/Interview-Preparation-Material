// Complexity is O(n)
// note I had solved using stack so it takes O(n) space and time.

/* 
Logic  is using two variable leftbracket and rightbracket
1) check is odd or not if odd then string balanced is not possible
2) if left bracket then add left_brac++ - reason is to check is any right bracket further available or not...
3) If right bracket then add right_brac++ - then check 2 condition left_bracket == 0 then that right bracket is need to changed else leftbracket != 0 then that left_brac++

*/
public class Main
{
    public static int countMinReversals(String s){
        int len = s.length();
        int leftBracket = 0, rightBracket = 0;
        if(len%2!=0){
            return 0;
        }
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='{'){
                leftBracket++;
            }else{
                if(leftBracket==0){
                    rightBracket--;
                }else{
                    leftBracket++;
                }
            }
        }
        int ans = (int)(Math.ceil((0.0 + leftBracket) / 2) + Math.ceil((0.0 + rightBracket) / 2));
        return ans;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String expr = "}}{{";
        System.out.println(countMinReversals(expr));
	}
}

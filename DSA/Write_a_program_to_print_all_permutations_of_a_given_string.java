// ----
// O(n*n) Complexity
public class Main
{
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    public static void permutation(String s, int left, int right){
        if(left==right){
            System.out.println(s);
        }else{
            for(int i=left;i<=right;i++){
                   String temp = swap(s,left,i);
                   permutation(temp,left+1,right);
                //   swap(s,i+1,left);
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "ABC";
		permutation(str,0,str.length()-1);
	}
}

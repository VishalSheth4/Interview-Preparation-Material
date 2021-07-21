// COMPLEXITY is O(n^2)

public class Main
{   
    public static int longestPalSubstr(String s){
        int n = s.length();
        int low,high;
        int start = 0;
        int maxLength = 1;
        for(int i=1;i<n;i++){
            low = i-1;
            high =i;
            //even
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if(high - low + 1 > maxLength){
                    maxLength = high-low+1;
                    start = low;
                }
                low--;
                high++;
            }
            
            low = i-1;
            high =i+1;
            //odd
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if(high - low + 1 > maxLength){
                    maxLength = high-low+1;
                    start = low;
                }
                low--;
                high++;
            }
        }
        
        System.out.print("Longest palindrome substring is: ");
        System.out.println(s.substring(start, start + maxLength));
        return maxLength;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
	}
}

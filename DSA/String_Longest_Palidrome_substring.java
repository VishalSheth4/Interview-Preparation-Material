/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static void printSubStr(String str,int low, int high)
    {
        System.out.println(str.substring(low, high + 1));
    }
    static int longestPalSubstr(String str)
    {
        int maxLength = 1;
        int start = 0;
        int len = str.length();
        int low, high;

        // One by one consider every character as center point of even and length palindromes
        for (int i = 1; i < len; ++i) {
            // Find the longest even length palindrome with center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                   && str.charAt(low)
                          == str.charAt(high)) {
                --low;
                ++high;
            }
          
              // Move back to the last possible valid palindrom substring
            // as that will anyway be the longest from above loop
            ++low; --high;
            if (str.charAt(low) == str.charAt(high) && high - low + 1 > maxLength) {
                start = low;
                maxLength = high - low + 1;
            }

            // Find the longest odd length
            // palindrome with center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                   && str.charAt(low)
                          == str.charAt(high)) {
                --low;
                ++high;
            }
          
              // Move back to the last possible valid palindrom substring
            // as that will anyway be the longest from above loop
            ++low; --high;
            if (str.charAt(low) == str.charAt(high) && high - low + 1 > maxLength) {
                start = low;
                maxLength = high - low + 1;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
	}
}

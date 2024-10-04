/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static void Minimum_Window(char s[], char t[]){
        int m[] = new int[256];
        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;
        
        // creating map
        for (int i = 0; i < t.length; i++) {
            if (m[t[i]] == 0)
                count++;
            m[t[i]]++;
        }
        
        // References of Window
        int i = 0,j = 0;
        // Traversing the window
    while (j < s.length){
        // Calculations
        m[s[j]]--;
        if (m[s[j]] == 0)
            count--;
        // Condition matching
        if (count == 0) {
            while (count == 0){
                // Sorting ans
                if (ans > j - i + 1){
                    ans = Math.min(ans, j - i + 1);
                    start = i;
                }
                // Sliding I Calculation for removing I
                m[s[i]]++;
                if (m[s[i]] > 0)
                    count++;
                i++;
            }
        }
        j++;
    }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.print(Minimum_Window(s.toCharArray(), t.toCharArray()));
	}
}

/ Java program to counts Palindromic Subsequence
// in a given String using recursion
// 3 Case need to remember 

// 1 case if ch(i) != ch(j) then PS(i,j-1) + PS(i+1,j) - PS(i+1,j-1)
// 2 case if ch(i) == ch(j) then PS(i,j-1) + PS(i+1,j) + 1
// 3 case if i==j then 1

class GFG {
    static int n;
    static int[][] dp = new int[1000][1000];
 
    static String str = "abcb";
 
    // Function return the total
    // palindromic subsequence
    static int countPS(int i, int j)
    {
 
        if (i > j)
            return 0;
 
        if (dp[i][j] != -1)
            return dp[i][j];
     
        if (i == j)
            return dp[i][j] = 1;
 
        else if (str.charAt(i) == str.charAt(j))
            return dp[i][j]
                = countPS(i + 1, j) +
                    countPS(i, j - 1) + 1;
 
        else
            return dp[i][j] = countPS(i + 1, j) +
                              countPS(i, j - 1) -
                              countPS(i + 1, j - 1);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        for (int i = 0; i < 1000; i++)
            for (int j = 0; j < 1000; j++)
                dp[i][j] = -1;
 
        n = str.length();
        System.out.println("Total palindromic subsequence"
                           + "are : " + countPS(0, n - 1));
    }
}

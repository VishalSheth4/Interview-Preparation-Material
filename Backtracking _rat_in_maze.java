// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static Vector<String> l = new Vector<>();
    static String s = "";
    
    static boolean isSafe(int row, int col, int m[][],int n, boolean visited[][])
    {
    if (row == -1 || row == n || col == -1 ||col == n || visited[row][col] ||  m[row][col] == 0)
        return false;
    return true;
    }
    
    public static void dfs(int i,int j, int n,int m[][], boolean visited[][], String s){
        
        if(i<0 || j<0 || i>n || j>n || m[n-1][n-1]==0 || visited[i][j]==true){
            return;
        }
        if(i==n-1 && j==n-1){
            System.out.println(s);
            l.add(s);
            return;
        }
        visited[i][j]=true;
        if (isSafe(i + 1, j, m,n, visited))
        {
        s += 'D';
        dfs(i + 1, j, n,m, visited,s);
        s = s.substring(0, s.length() - 1);
        }
 
        if (isSafe(i, j-1, m,n, visited))
        {
        s += 'L';
        dfs(i, j-1, n,m, visited,s);
        s = s.substring(0, s.length() - 1);
        }
 
        if (isSafe(i,  j+1, m,n, visited))
        {
        s += 'R';
        dfs(i, j+1, n,m, visited,s);
        s = s.substring(0, s.length() - 1);
        }
 
        if (isSafe(i-1, j,m,n, visited))
        {
        s += 'U';
        dfs(i-1,j, n,m, visited,s);
        s = s.substring(0, s.length() - 1);
        }
        visited[i][j]=false;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean a[][] = new boolean[n+1][n+1];
        dfs(0,0,n,m,a,s);
        ArrayList<String> Arrlist = new ArrayList<String>();
  
        // Convert Vector to ArrayList
        for (int i = 0; i < l.size(); i++)
            Arrlist.add(l.get(i));
        
        Collections.sort(Arrlist);    
        return Arrlist;
    }
}

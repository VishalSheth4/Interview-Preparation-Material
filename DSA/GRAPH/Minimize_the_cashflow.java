/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    static int getMaxIndex(int[] amount){
        int maxIndex=0;
        for(int i=1;i<amount.length;i++){
            if(amount[i] > amount[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    static int getMinIndex(int[] amount){
        int minIndex=0;
        for(int i=1;i<amount.length;i++){
            if(amount[i] < amount[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    static void settleDebit(int[] amount){
        int maxCredit = getMaxIndex(amount);
        int maxDebit = getMinIndex(amount);
        
        // Base Case 
        if(amount[maxDebit] == 0 && amount[maxCredit] == 0){
            return;
        }
        
        // Settle minimum of debit and credit 
        int minAmount = Math.min(-amount[maxDebit], amount[maxCredit]);
        amount[maxCredit] -= minAmount;
        amount[maxDebit] += minAmount;
        
        System.out.println("Person " + maxDebit + " pays " + minAmount + " to Person " + maxCredit);

        // Recur
        settleDebit(amount);
    }
    public static void minimizeCashFlow(int[][] graph){
        int n = graph.length;
        int[] amount = new int[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                amount[i] += (graph[j][i] - graph[i][j]);
            }
        }
        settleDebit(amount);
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[][] graph = {
            {0, 1000, 2000},
            {0, 0, 5000},
            {0, 0, 0}
        };
        minimizeCashFlow(graph);
	}
}

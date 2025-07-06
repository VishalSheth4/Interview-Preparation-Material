/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    public static boolean safe(int node, int[][] graph, int[] color, int c, int V){
        for(int i=0;i<V;i++){
            if (graph[node][i] == 1 && color[i] == c){
                return false;
            }
        }
        return true;
    }
    public static boolean solve(int node, int[][] graph, int[] color, int M, int V){
        if(node==V){
            return true;
        }
        for(int c=1; c<=M;c++){
            if(safe(node, graph,color,c,V)){
                color[node]=c;
                
                if(solve(node+1,graph, color, M, V)){
                    return true;
                }
                
                color[node]=0;
            }
        }
        return false;
    }
    public static boolean graphColoring(int[][] graph, int M, int V){
        int[] color = new int[V];
        return solve(0, graph,color, M, V);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int V=4;   // total number of nodes
		int M=1;  // total number of colors
		
		int[][] graph = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        
        if (graphColoring(graph, M, V)) {
            System.out.println("Solution exists using " + M + " colors.");
        } else {
            System.out.println("No solution exists using " + M + " colors.");
        }
	}
}

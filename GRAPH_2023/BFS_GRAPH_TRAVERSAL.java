/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class BFS_GRAPH_TRAVERSAL
{
    static int V;
    static ArrayList<ArrayList<Integer>> adj;
    BFS_GRAPH_TRAVERSAL(){
		int V=4;
		 adj = new ArrayList<ArrayList<Integer>>(V);
		
		for (int i=0;i<V; i++){
		    adj.add(new ArrayList<Integer>());
		}
		System.out.println(adj);
    }
    static void printGraph(int V){
        for(int i=0; i<V; i++){
            System.out.print(i + "->");
            for(int j=0; j<adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + "-");
            }
            System.out.println();
        }
    }
    static void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    static void BFS(int s){
        boolean visited[] = new boolean[4];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
        while (queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");
            ArrayList<Integer> temp = adj.get(s);
            // System.out.println(temp);
            for(int i=0; i<adj.get(s).size(); i++){
                int n = adj.get(s).get(i);
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Main m = new Main();
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);
        // System.out.println(adj);
// 		printGraph(V);
		BFS(2);
	}
}
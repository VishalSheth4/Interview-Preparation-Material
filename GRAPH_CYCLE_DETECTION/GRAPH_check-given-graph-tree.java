import java.util.*;
import java.io.*;

 class Graph{
        private int V;    // No. of vertices
        private LinkedList<Integer> adj[];   // Adjacency List
        
        Graph(int v){
            V = v;
            adj = new LinkedList[V];
            for(int i=0;i<V;i++){
                adj[i] = new LinkedList<Integer>();
            }
        }
        
        void addEdge(int v, int w){
            adj[v].add(w);
            adj[w].add(v);
        }
        
        public boolean isCyclicUtil(int v, boolean visited[], int parent){
            visited[v]= true;
            Integer i;
            
            Iterator<Integer> it = adj[v].iterator();
            while(it.hasNext()){
                i = it.next();
                if(!visited[i]){
                    if (isCyclicUtil(i, visited, v))
                    return true;
                }else if(i!=parent){
                    return true;
                }
            }
            return false;
        }    
        public boolean isTree(){
            boolean visited[] = new boolean[V];
            //  Mark all node as Un-Visited
            for(int i=0;i<V;i++){
                visited[i]=false;
            }
            
            if(isCyclicUtil(0,visited,-1)){
                return false;
            }
            
            // for Un-Visited Node or Seperated Node
            for(int u=0;u<V;u++){
                if(!visited[u]){
                    return false;
                }
            }
            return true;
        }

    }
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
	}
}

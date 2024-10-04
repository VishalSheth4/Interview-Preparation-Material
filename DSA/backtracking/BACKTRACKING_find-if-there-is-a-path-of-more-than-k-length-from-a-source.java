import java.util.*;
public class Main
{
    static class Node{
        int v;
        int weight;
        
        Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
        int getV() { return v; }
        int getWeight() { return weight; }
    }
    static class Graph{
        int V;
        ArrayList<ArrayList<Node>> adj;
        
        Graph(int V){
            this.V = V;
            adj = new ArrayList<ArrayList<Node>>(V);
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<Node>());
            }
        }
        
        void addEdge(int u, int v, int weight){
            // Imp ----
            Node n1 = new Node(v,weight);
            adj.get(u).add(n1);
            
            Node n2 = new Node(u,weight);
            adj.get(v).add(n2);
        }
    
        boolean pathMoreThanK(int src, int k){
            boolean path[] = new boolean[V];
            Arrays.fill(path,false);
            path[src] = true;
            return pathMoreThanKUtil(src, k, path);
        }
    
        boolean pathMoreThanKUtil(int src, int k, boolean[] path){
            if(k <=0) { return true; }
                
            ArrayList<Node> it = adj.get(src);
            for(int i=0;i<adj.get(src).size();i++){
                Node vertex = it.get(i);
            
                int v = vertex.v;
                int w = vertex.weight;
                
                if(path[v] == true) { continue; }
                
                if(w >= k) { return true; }
                
                path[v] = true;
                
                if (pathMoreThanKUtil(v, k-w, path)) { return true; }
                    
                path[v] = false;    
            }
            return false;
        }
    }    
	public static void main(String[] args) {
		System.out.println("Hello World");
		int V = 9;
		int src = 0;
		int k = 62;
		
		Graph g = new Graph(V);
 
        // making above shown graph
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
		
		if(g.pathMoreThanK(src, k))
          System.out.println("YES");
        else
          System.out.println("NO");
          
        
        k = 60;
        if(g.pathMoreThanK(src, k))
          System.out.println("YES");
        else
          System.out.println("NO");  
	}
}

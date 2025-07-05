class Solution {
    public int find(int[] parent, int i){
        if(parent[i] != i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1]; 

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if(rootU == rootV){
                return edge;
            } else {
                parent[rootU] = rootV;
            }
        }

        return new int[0];
    }
}

/*
n = 5;
edges = [[0,1], [0,2], [0,3], [1,4]];
// Output: true
*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A tree should have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Initialize parent array
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Union-Find
        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            
            // Cycle detected
            if (x == y) return false;
            
            // Union
            parent[x] = y;
        }

        return true;
    }

    // Path Compression
    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}


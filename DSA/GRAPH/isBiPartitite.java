class Solution {
    
    public boolean isBipartite(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Step 2: Initialize color array
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        // Step 3: Check
        for (int i = 0; i < V; i++) {
            if (color[i] != -1) continue;
        
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 0;
        
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int next : adj.get(curr)) {
                    if (color[next] == -1) {
                        color[next] = 1 - color[curr];
                        q.offer(next);
                    } else if (color[next] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

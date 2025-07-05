class Solution {
    
    public int find(int[] parent, int i){
        if(parent[i]!=i){
            parent[i]=find(parent, parent[i]);
        }
        return parent[i];
    }
    public int findCircleNum(int[][] g) {
       int n = g.length;
       int parent[] = new int[n];

       for(int i=0;i<n;i++){
        parent[i]=i;
       }

       for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){

                }else if(g[i][j]==1){
                    int rootX = find(parent, i);
                    int rootY = find(parent, j);

                    parent[rootX]=rootY;
                }
            }
       }
       Set<Integer> l = new HashSet<>();
       for(int i = 0; i < n; i++){
            l.add(find(parent, i));  // ✅ Call find() here
        }
       return l.size();
    }
}

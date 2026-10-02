// Same DSU Code 
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
        }
        return dsu.count;
    }
}

class DSU {
    int[] p, sz;
    int count;

    DSU(int n) {
        p = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            p[i] = i;
            sz[i] = 1;
        }
    }

    int find(int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (sz[a] < sz[b]) { int t = a; a = b; b = t; }
        p[b] = a;
        sz[a] += sz[b];
        count--;
        return true;
    }
}

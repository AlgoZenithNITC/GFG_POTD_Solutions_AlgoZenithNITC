class Solution {
    private static boolean checkCover(int n, int k, int m, ArrayList<ArrayList<Integer>> adj){
        int set = (1 << k) - 1;
        int limit = (1 << n);
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            visited.add(new ArrayList<Boolean>(n + 1));
            for (int j = 0; j < n + 1; j++) {
                visited.get(i).add(false);
            }
        }
        while (set < limit) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    visited.get(i).set(j, false);
                }
            }
            int cnt = 0;
            for (int j = 1, v = 1; j < limit; j = j << 1, v++) {
                if ( (set & j) != 0 ) {
                    for (int l = 1; l <= n; l++) {
                        if (adj.get(v).get(l) == 1 && !visited.get(v).get(l)) {
                            visited.get(v).set(l, true);
                            visited.get(l).set(v, true);
                            cnt++;
                        }
                    }
                }
            }
            if (cnt == m) {
                return true;
            }
            int c = set & -set;
            int r = set + c;
            set = (((r ^ set) >> 2) / c) | r;
        }
        return false;
    }
    private static int vertexCoverHelper(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        int low = 1, high = n;
        while (high > low) {
            int mid = (low + high) >> 1;
            if (checkCover(n, mid, m, adj) == false) {
                low = mid + 1;
            } 
            else {
                high = mid;
            }
        }
        return low;
    }
    public static int vertexCover(int n, int m, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n + 1);
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<Integer>(n + 1));
            for(int j = 0; j < n + 1; j++){
                adj.get(i).add(0);
            }
        }
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).set(edges[i][1], 1);
            adj.get(edges[i][1]).set(edges[i][0], 1);
        }
        return vertexCoverHelper(adj, n, m);
    }
}

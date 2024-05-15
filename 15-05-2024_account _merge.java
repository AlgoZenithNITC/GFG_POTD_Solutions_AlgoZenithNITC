//User function Template for Java
class DisjointSet {
    private int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int parU = findParent(u);
        int parV = findParent(v);
        if (parU == parV) return;
        if (size[parU] < size[parV]) {
            parent[parU] = parV;
            size[parV] += size[parU];
        } else {
            parent[parV] = parU;
            size[parU] += size[parV];
        }
    }
}

class Solution {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mp = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        int par = 0;
        for (List<String> x : accounts) {
            for (int i = 1; i < x.size(); ++i) {
                String mail = x.get(i);
                if (mp.containsKey(mail)) {
                    ds.unionBySize(par, mp.get(mail));
                } else {
                    mp.put(mail, par);
                }
            }
            par++;
        }
        List<String>[] mergedMail = new ArrayList[n];
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            String mail = entry.getKey();
            int parNode = ds.findParent(entry.getValue());
            if (mergedMail[parNode] == null) {
                mergedMail[parNode] = new ArrayList<>();
            }
            mergedMail[parNode].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (mergedMail[i] == null || mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }
}

     

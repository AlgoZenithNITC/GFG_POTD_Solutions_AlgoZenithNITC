class Solution {
    public List<List<Integer>> rotateMatrix(int k, List<List<Integer>> mat) {
        int n = mat.size(), m = mat.get(0).size();
        List<List<Integer>> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(m));
        }
        k %= m;
        if (k == 0) return mat;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = k; j < m; j++, x++) {
                ans.get(i).set(x, mat.get(i).get(j));
            }
            for (int j = 0; j < k; j++, x++) {
                ans.get(i).set(x, mat.get(i).get(j));
            }
        }
        return ans;
    }
}


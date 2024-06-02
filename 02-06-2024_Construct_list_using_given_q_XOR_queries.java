class Solution {
    public List<Integer> constructList(int k, List<List<Integer>> q) {
        List<Integer> ans = new ArrayList<>();
        int x = 0;
        ans.add(0);
        for (List<Integer> query : q) {
            if (query.get(0) == 0) {
                ans.add(query.get(1) ^ x);
            } else {
                x ^= query.get(1);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) ^ x);
        }
        Collections.sort(ans);
        return ans;
    }
}


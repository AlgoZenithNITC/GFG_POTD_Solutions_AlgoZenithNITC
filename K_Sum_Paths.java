class Solution{
    final int mod = (int)1e9 + 7;
    int total = 0;
    
    void solve(Node root, int k, int sum, HashMap<Integer, Integer> ending){
        if(root == null){
            return;
        }
        sum += root.data;
        total = (total + ending.getOrDefault(sum - k, 0))%mod;
        ending.put(sum, ending.getOrDefault(sum, 0) + 1);
        solve(root.left, k, sum, ending);
        solve(root.right, k, sum, ending);
        ending.put(sum, ending.get(sum) - 1);
    }
    
    public int sumK(Node root,int k){
        HashMap<Integer, Integer> ending = new HashMap<>();
        ending.put(0, 1);
        solve(root, k, 0, ending);
        return total;
    }
}

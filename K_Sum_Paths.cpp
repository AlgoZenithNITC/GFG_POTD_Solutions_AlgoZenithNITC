class Solution{
  public:
    const int mod = 1e9 + 7;
    int total = 0;
    void solve(Node *root, int k, int sum, unordered_map<int, int> &ending){
        if(!root){
            return;
        }
        sum += root -> data;
        total = (total + ending[sum - k])%mod;
        ending[sum]++;
        solve(root -> left, k, sum, ending);
        solve(root -> right, k, sum, ending);
        ending[sum]--;
    }
    int sumK(Node *root, int k){
        unordered_map<int, int> ending;
        ending[0] = 1;
        solve(root, k, 0, ending);
        return total;
    }
};

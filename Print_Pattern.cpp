class Solution{
public:
    vector<int> ans;
    vector<int> pattern(int N){
        if(N <= 0){
            ans.push_back(N);
            return ans;
        }
        ans.push_back(N);
        pattern(N - 5);
        ans.push_back(N);
        return ans;
    }
};

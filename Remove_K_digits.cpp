class Solution {
  public:
    string removeKdigits(string S, int K){
        int n = S.length();
        if(n == K){
            return "0";
        }
        stack<char> store;
        for(int i = 0; i < n; i++){
            while(K and !store.empty() and store.top() > S[i]){
                store.pop();
                K--;
            }
            store.push(S[i]);
        }
        while(K){
            store.pop();
            K--;
        }
        string ans = "";
        while(!store.empty()){
            ans.push_back(store.top());
            store.pop();
        }
        reverse(ans.begin(), ans.end());
        for(int i = 0; i < ans.size(); i++){
            if(ans[i] != '0'){
                return ans.substr(i);
            }
        }
        return "0";
    }
};

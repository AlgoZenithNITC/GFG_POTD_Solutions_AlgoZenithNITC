class Solution {
  public:
    vector<int> leafNodes(vector<int>& preorder) {
        int n = preorder.size();
        stack<int> st;
        vector<int> leafs;
        int leaf;
        for(int i=0;i<n;i++) {
            if(!st.empty() && st.top() > preorder[i]) {
                st.push(preorder[i]);
            } else {
                int count = 0;
                if(!st.empty()) leaf = st.top();
                while(!st.empty() && st.top() < preorder[i]) {
                    st.pop();
                    count++;
                }
                st.push(preorder[i]);
                if(count >= 2 ) leafs.push_back(leaf);
            }
        }
        leafs.push_back(st.top());
        return leafs;
    }
};

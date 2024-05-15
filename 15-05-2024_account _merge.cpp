// User function Template for C++

class DisjointSet{
    vector<int> parent, size;
public:    
    DisjointSet(int n = 0){
        parent.resize(n+1);
        size.resize(n+1, 1);
        for(int i=0; i<=n; ++i){
            parent[i] = i;
        }
    }
    int findParent(int node){
        if(parent[node] == node)return node;
        return parent[node] = findParent(parent[node]);
    }

    void unionBySize(int u, int v){
        int parU = findParent(u);
        int parV = findParent(v);
        if(parU == parV)return;
        if(size[parU] < size[parV]){
            parent[parU] = parV;
            size[parV] += parU;
        }else{
            parent[parV] = parU;
            size[parU] += parV;
        }
    }
};


class Solution{
  public:

    vector<vector<string>> accountsMerge(vector<vector<string>> &accounts) {
        unordered_map<string, int> mp;
        int n = accounts.size();
        DisjointSet ds(n);
        int par = 0;
        for(vector<string> &x : accounts){
            for(int i=1; i<x.size(); ++i){
                string mail = x[i];
                if(mp.find(mail) != mp.end()){
                    ds.unionBySize(par, mp[mail]);
                }else{
                    mp[mail] = par;
                }
            }
            par++;
        }
        vector<string> mergedMail[n];
        for(auto it: mp){
            string mail = it.first;
            int parNode = ds.findParent(it.second);
            mergedMail[parNode].push_back(mail);
        }
        vector<vector<string>> ans;
        for(int i=0; i<n; ++i){
            if(mergedMail[i].size() == 0)continue;
            sort(mergedMail[i].begin(), mergedMail[i].end());
            vector<string> temp;
            temp.push_back(accounts[i][0]);
            for(auto &x : mergedMail[i]){
                temp.push_back(x);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
            unordered_map<string,vector<string>> temp;
             vector<vector<string>> ans;
             for(int i=0;i<strs.size();i++){
                 
                 string s=strs[i];
                 sort(strs[i].begin(),strs[i].end());
                 temp[strs[i]].push_back(s);

             }

             for(auto i:temp){
                 ans.push_back(i.second);
             }

             return ans;
    }
};

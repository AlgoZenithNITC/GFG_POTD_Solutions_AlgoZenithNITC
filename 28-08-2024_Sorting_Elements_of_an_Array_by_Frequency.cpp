class Solution {
    public:

    static bool sortByVal(const pair<int, int>& a, const pair<int, int>& b) {
        if (a.second == b.second)
            return a.first < b.first;

        return a.second > b.second;
    }

    vector<int> sortByFreq(vector<int>& arr) {
        int n = arr.size();
        vector<pair<int, int>> v;
        unordered_map<int,int>mp;
        for(int i = 0; i < n; i++){
            mp[arr[i]]++;
        }
        
        for(auto el: mp){
            v.push_back({el.first, el.second});
        }
        sort(v.begin(), v.end(), sortByVal);
        
        vector<int>ans;
        for(int i = 0; i < v.size(); i++){
            for(int j = 0; j < v[i].second; j++){
                ans.push_back(v[i].first);
            }
        }
        return ans;
    }
};

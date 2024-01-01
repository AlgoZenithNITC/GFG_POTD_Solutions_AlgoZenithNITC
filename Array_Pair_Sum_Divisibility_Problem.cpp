class Solution {
  public:
    bool canPair(vector<int> nums, int k){
        if(nums.size()%2 != 0){
            return false;
        }
        unordered_map<int, int> mp;
        for(int i : nums){
            int y = i%k;
            if(mp[(k - y)%k] != 0){
                mp[(k - y)%k]--;
            }
            else{
                mp[y]++;
            }
        }
        for(auto it : mp){
            if(it.second != 0){
                return false;
            }
        }
        return true;
    }
};

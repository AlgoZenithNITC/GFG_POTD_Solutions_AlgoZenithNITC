int longestKSubstr(string &s, int k) {
    map<char,int> mp;
    
    int l = 0, r = 0, ans = -1;
    
    while(r < s.length()){
        mp[s[r]]++;
        if(mp.size() > k){
            mp[s[l]]--;
            if(mp[s[l]] == 0)
                mp.erase(s[l]);
            l++;
        }
        if(mp.size() == k)
            ans = max(ans, r-l+1);
        r++;
    }
    
    return ans;
}

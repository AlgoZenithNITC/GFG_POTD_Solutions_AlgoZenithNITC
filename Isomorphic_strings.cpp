class Solution{
    public:
    bool areIsomorphic(string s1, string s2){
        if(s1.length() != s2.length()){
            return false;
        }
        vector<int> map(26, -1);
        int n = s1.length(), used = 0;
        for(int i = 0; i < n; i++){
            if(map[s1[i] - 'a'] != -1){
                if(map[s1[i] - 'a'] != s2[i] - 'a'){
                    return false;
                }
            }else{
                if((used >> (s2[i] - 'a'))&1){
                    return false;
                }else{
                    map[s1[i] - 'a'] = s2[i] - 'a';
                    used |= (1 << (s2[i] - 'a'));
                }
            }
        }
        return true;
    }
};

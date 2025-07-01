class Solution {
  public:
    int substrCount(string &s, int k) {
        
        
        int distinct = 0;
        int res = 0;
        
        unordered_map<int,int> freq;
        for(int i=0;i<k;i++)
        {
             freq[s[i]-'a']++;
             
             if(freq[s[i]-'a']==1)
                distinct++;
        }
        
        if(distinct == k-1)
            res++;
            
        for(int i=k;i<s.size();i++)
        {
             freq[s[i-k]-'a']--;
             
             if(freq[s[i-k] - 'a']==0) 
                distinct--;
                
            freq[s[i]-'a']++;
             if(freq[s[i]-'a']==1)
                distinct++;
            
        
            if(distinct == k-1)
            res++;
            
        }
        
        
        return res;
        
        
        
    }
};

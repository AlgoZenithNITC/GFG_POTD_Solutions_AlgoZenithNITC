class Solution {
  public:
    
    int atmostK(string &s, int k)
    {
       int n = s.length();
       int ans = 0;
       
       vector<int> count(26,0);
       
       int distinct = 0;
       
       int i=0;
       
       
       for(int j=0;j<n;j++)
       {
           count[s[j]-'a']+=1;
           
        
           if(count[s[j]-'a']==1) distinct++; 
           //if we already saw that char there is another of the same to get another substring with k distinct since the number of distinct will not be changing
       
           
           //if we have greater than k reduce
           
           while(distinct>k)
           {
                count[s[i]-'a']--;
                
                if(count[s[i]-'a']==0) distinct--; //we lost a distinct char
                i++;
           }
           
           
           ans = ans + j-i+1;
           
       }
       
       return ans;
    }
    
    
    int countSubstr(string& s, int k) {
    
     int n = s.size();
      
     int res = 0;
     
     res = atmostK(s,k)-atmostK(s,k-1);

     return res;
     
    }
};



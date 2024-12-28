class Solution {
  public:
    vector<vector<int>> findTriplets(vector<int> &arr) 
    {   
       set <vector<int>> set ; 
        
       int len = arr.size();
       
       unordered_map<int, vector< pair<int,int> > > sumwithpair;
       
       
       for(int i=0;i<len;i++)
       {
           for(int j=i+1;j<len;j++)
           {
               int sum = arr[i]+arr[j];
               
               sumwithpair[sum].push_back({i,j});
           }
       }
       
       
       for(int i=0;i<len;i++)
       {
           int complement = -arr[i];
           
           if(sumwithpair.find(complement)!=sumwithpair.end())
           {
               for(auto pair : sumwithpair[complement])
               {
                   if(i!= pair.first && i!= pair.second )
                   {
                       vector <int> values = {i,pair.first,pair.second};
                       sort(values.begin(),values.end());
                       
                       set.insert(values);
                   }
               }
           }
       }
        
        vector<vector <int> > result (set.begin(),set.end());
        
        return result;
        
        
    }
};

class Solution {
  public:
    vector<int> spirallyTraverse(vector<vector<int> > &mat) 
    {
    
        vector <int> result;
        int left = 0;
        int top = 0 ;
            
        int bottom = mat.size()-1;
        
        int right = mat[0].size()-1;
        
        
        while(top<=bottom && left <=right)
        {
            
            for(int i = left ;i<=right;i++)
            {
               result.push_back(mat[top][i]);
            }
            
            top++;
            
            
            for(int i=top;i<=bottom;i++)
            {
                result.push_back(mat[i][right]);
            }
            
            right--;
            
            
            //check if top crossed over bottom
            if(top<=bottom)
            {
            for(int i=right;i>=left;i--)
            {
                result.push_back(mat[bottom][i]);
            }
            
            bottom--;
            
            }
            
            
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    result.push_back(mat[i][left]);
                }
                
               left++;
            }
        }
        
        return result;
        
    }
};

class Solution {
  public:
    int minJumps(vector<int>& arr) {
        int n = arr.size();
        
        if(n==1)
        return 0;
        
        int i = 0;
        int jumps = 0;
        
        while(i<n)
        {
            if(arr[i]==0)
            return -1;
            
            jumps++;
            int m = i;
            
            for(int j = i+1 ; j<= i + arr[i] && j ; j++)
            {
                if (j >= n - 1) 
                    return jumps;
                
                if (arr[j] + j >= arr[m] + m)
                    m = j;
            }
            
            i = m;
        }
        return jumps;
    }
};

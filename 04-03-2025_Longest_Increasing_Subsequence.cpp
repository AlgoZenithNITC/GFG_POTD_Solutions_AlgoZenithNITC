class Solution {
  public:
    int lis(vector<int>& arr) {
        // code here
        if(arr.size()==0)
        {
            return 0;
        }
        vector <int> lis(arr.size(), 1);
        for(int i=1; i<arr.size(); ++i)
        {
            for(int j=0; j<i; ++j)
            {
                if(arr[i]>arr[j])
                {
                    if(lis[j]+1 > lis[i])
                    {
                        lis[i] = lis[j] + 1;
                    }
                }
            }
        }
        int max = lis[0];
        for(int i=1; i<arr.size(); ++i)
        {
            if(lis[i]>max)
            {
                max = lis[i];
            }
        }
        return max;
    }
};

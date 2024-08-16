class Solution
{
    public:
    //Function to find the maximum number of cuts.
    int maximizeTheCuts(int n, int x, int y, int z)
    {
        int arr[3];
        arr[0]=x;
        arr[1]=y;
        arr[2]=z;
        
        //creating a dp[] array and initializing all values with 0.
        int dp[n+1];
        memset(dp,0,sizeof(dp));
        
        for(int j=0;j<3;j++)
        {
            //updating the point where we can reach from x,y,z.
            for(int i=1;i<=n;i++)
            {
                //we will update dp[i] if the point is x,y,z or if the
                //points are visited by some combination of x,y,z.
                if(i==arr[j] or (i>arr[j] and dp[i-arr[j]]>0))
                    dp[i]=max(dp[i-arr[j]]+1,dp[i]);
                }
        }
        //returning the result.
        return dp[n];
    }
};


//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
/*You are required to complete this method */

class Solution{
  public:
    vector<int> matrixDiagonally(vector<vector<int>>&mat)
    {
         //Your code here
         int n= mat.size();
         
         vector<int> ans;
         
         for(int i=0;i<n;i++){
             if(i%2){
                 for(int j=0;j<=i;j++) ans.push_back(mat[j][i-j]);
             }else{
                 for(int j=i;j>=0;j--) ans.push_back(mat[j][i-j]);
             }
         }
         
         for(int i=1;i<n;i++){
             if((i%2)^(n%2)){
                 for(int j=n-i-1;j>=0;j--) ans.push_back(mat[i+j][n-1-j]);
             }else{
                 for(int j=0;j<n-i;j++) ans.push_back(mat[i+j][n-1-j]);
             }
         }
         
         return ans;
    }
};


//{ Driver Code Starts.
int main()
{
    int T;
    cin>>T;
  
    while(T--)
    {
        int n;
        int k=0;
        //cin>>k;
        cin>>n;
        vector<vector<int>>mat(n, vector<int>(n));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cin >> mat[i][j];
            }
        }
        Solution obj;
        vector<int>ans = obj.matrixDiagonally(mat);
        for(auto i: ans)cout << i << " ";
        cout << "\n";
        
       
    }
}
// } Driver Code Ends
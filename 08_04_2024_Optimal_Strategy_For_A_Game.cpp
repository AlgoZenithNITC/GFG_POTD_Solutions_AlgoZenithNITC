//Function to find the maximum possible amount of money we can win.

class Solution{
    public:
long long maximumAmount(int n, int arr[]) 
{ 
    //creating a table to store solutions of subproblems.
    int table[n][n]; 
  
    //filling table using above recursive formula. Note that the 
    //table is filled in diagonal fashion, from diagonal elements 
    //to table[0][n-1] which is the result. 
    for (int gap = 0; gap < n; ++gap) 
    { 
        for (int i = 0, j = gap; j < n; ++i, ++j) 
        { 
            //Here x is value of table[i + 2][j], y istable[i + 1][j - 1] and 
            // z is table[i][j - 2] in above recursive formula.
            
            int x = ((i + 2) <= j) ? table[i + 2][j] : 0; 
            int y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0; 
            int z = (i <= (j - 2)) ? table[i][j - 2] : 0; 
  
            table[i][j] = max(arr[i] + min(x, y), arr[j] + min(y, z)); 
        } 
    } 
    //returning the result.
    return table[0][n - 1]; 
} 
};

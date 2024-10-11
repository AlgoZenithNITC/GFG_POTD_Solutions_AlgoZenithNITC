class Solution {
  public:
    vector<int> rearrange(vector<int>& arr) {
        // Code here
        int i, j, temp;
        int n = arr.size();
        // Iterate over the array
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                // Check is any ar[j]
                // exists such that
                // ar[j] is equal to i
                if (arr[j] == i) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
        }
    
        // Iterate over array
        for (i = 0; i < n; i++)
        {
            // If not present
            if (arr[i] != i)
            {
                arr[i] = -1;
            }
        }
        
        return arr;
    }
};

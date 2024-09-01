class Solution {
  public:
    int maxPathSum(vector<int> &ar1, vector<int> &ar2) {
        int m = ar1.size(), n = ar2.size();
        int i = 0, j = 0;

        int result = 0, sum1 = 0, sum2 = 0;
    
        while (i < m && j < n) {
            if (ar1[i] < ar2[j])
                sum1 += ar1[i++];
    
            else if (ar1[i] > ar2[j])
                sum2 += ar2[j++];
    
            else
            {
                result += max(sum1, sum2) + ar1[i];
    
                sum1 = 0;
                sum2 = 0;
    
                i++;
                j++;
            }
        }
    
        while (i < m)
            sum1 += ar1[i++];
    
        while (j < n)
            sum2 += ar2[j++];
    
        result += max(sum1, sum2);
    
        return result;
    }
};

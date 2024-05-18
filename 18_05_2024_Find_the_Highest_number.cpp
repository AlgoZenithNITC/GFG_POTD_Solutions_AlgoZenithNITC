class Solution {
public:
    
    int findPeakElement(vector<int>& a)
    {
        int max = a[0];
        int i;
        for (i = 1; i < a.size(); i++) {
            if (a[i] > max)
                max = a[i];

            
            else
                break;
        }

        return max;
    }
};

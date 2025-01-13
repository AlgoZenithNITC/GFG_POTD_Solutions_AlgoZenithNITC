class Solution {

  public:
    int maxWater(vector<int> &arr) {
        // code here
        if(arr.size()<2)
        {
            return 0;
        }
        int left = 0;
        int right = arr.size()-1;
        int max = 0;
        while(left < right)
        {
            int temp;
            if(arr[left]<arr[right])
            {
                temp = arr[left];
            }
            else
            {
                temp = arr[right];
            }
            temp *= (right-left);
            max = max > temp? max : temp;
            if(arr[left]<arr[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return max;
    }
};

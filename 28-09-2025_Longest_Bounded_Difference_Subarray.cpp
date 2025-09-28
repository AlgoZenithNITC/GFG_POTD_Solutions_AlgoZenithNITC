class Solution {
public:
    vector<int> longestSubarray(vector<int>& arr, int x) {
        deque<int> maxd, mind;
        int l = 0, bl = 0, br = 0;
        int n = arr.size();
        
        for (int r = 0; r < n; r++) {
            // maintain max deque (decreasing)
            while (!maxd.empty() && maxd.back() < arr[r]) 
                maxd.pop_back();
            maxd.push_back(arr[r]);
            
            // maintain min deque (increasing)
            while (!mind.empty() && mind.back() > arr[r]) 
                mind.pop_back();
            mind.push_back(arr[r]);
            
            // shrink if invalid
            while (!maxd.empty() && !mind.empty() && maxd.front() - mind.front() > x) {
                if (arr[l] == maxd.front()) maxd.pop_front();
                if (arr[l] == mind.front()) mind.pop_front();
                l++;
            }
            
            // update best window
            if (r - l > br - bl) {
                br = r;
                bl = l;
            }
        }
        return vector<int>(arr.begin() + bl, arr.begin() + br + 1);
    }
};

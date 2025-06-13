class Solution {
public:
    int kokoEat(vector<int>& arr, int k) {
        int left = 1;
        int right = *max_element(arr.begin(), arr.end());
        
        auto can_finish = [&](int speed) {
            int hours = 0;
            for (int bananas : arr) {
                hours += (bananas + speed - 1) / speed;
            }
            return hours <= k;
        };
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (can_finish(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
};

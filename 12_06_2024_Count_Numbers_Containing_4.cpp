class Solution {
  public:
    int countNumberswith4(int n) {
        int count = 0;
        
        for (int i = 1; i <= n; ++i) {
            if (to_string(i).find('4') != string::npos) {
                ++count;
            }
        }
        
        return count;
    }
};

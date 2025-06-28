class Solution {
  public:
    vector<int> countLessEq(vector<int>& a, vector<int>& b) {
        // code here
        int maxVal = 0;
    for (int num : a) maxVal = max(maxVal, num);
    for (int num : b) maxVal = max(maxVal, num);

    
    vector<int> freq(maxVal + 2, 0);
    for (int num : b) {
        freq[num]++;
    }

   
    for (int i = 1; i <= maxVal + 1; ++i) {
        freq[i] += freq[i - 1];
    }

   
    vector<int> result;
    for (int x : a) {
        result.push_back(freq[x]);
    }

    return result;
    }
};

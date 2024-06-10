class Solution {
public:
    void matchPairs(int n, char nuts[], char bolts[])
    {
        // code here

        vector<char> v = { '!', '#', '$', '%', '&',
                           '*', '@', '^', '~' };

        int i1 = 0, i2 = 0;
        for (int i = 0; i < v.size(); i++) {

            for (int j = 0; j < n; j++) {
                if (bolts[j] == v[i]) {
                    swap(bolts[j], bolts[i1]);
                    i1++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (nuts[j] == v[i]) {
                    swap(nuts[j], nuts[i2]);
                    i2++;
                }
            }
        }
    }
};

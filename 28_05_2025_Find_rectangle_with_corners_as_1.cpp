#include <iostream>
#include <vector>

class Solution {
public:
    bool ValidCorner(std::vector<std::vector<int>>& mat) {
        std::vector<int> row;

        for (int i = 0; i < mat.size(); ++i) {
            int count = 0;
            for (int val : mat[i]) {
                if (val == 1) ++count;
            }
            if (count >= 2) row.push_back(i);
        }

        for (int i = 0; i < row.size(); ++i) {
            for (int j = i + 1; j < row.size(); ++j) {
                int c = 0;
                for (int k = 0; k < mat[0].size(); ++k) {
                    if (mat[row[i]][k] == 1 && mat[row[j]][k] == 1) {
                        c++;
                        if (c == 2) return true;
                    }
                }
            }
        }

        return false;
    }
};
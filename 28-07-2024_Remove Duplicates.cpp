class Solution {
public:
    string removeDups(string S)
    {
        unordered_set<char> s1;

        string ans;

        for (auto& it : S) {
            if (s1.find(it) == s1.end()) {
                ans += it;
            }

            s1.insert(it);
        }

        return ans;
    }
};

void genPermutation(int i, string &s, vector<bool> &used, 
                    string &curr, unordered_set<string>& st) {
    if (i == s.size()) {
        st.insert(curr);
        return;
    }

    for (int j = 0; j < s.size(); j++) {
        if (!used[j]) {
            used[j] = true;
          	curr.push_back(s[j]);
            genPermutation(i + 1, s, used, curr,st);
          	used[j] = false;
          	curr.pop_back();
        }
    }
}

vector<string> findPermutation(string &s) {

    vector<bool> used(s.size(), false);
    unordered_set<string> st;
  
  	string curr = "";

    genPermutation(0, s, used, curr, st);
    vector<string> res(st.begin(), st.end());
    return res;
}
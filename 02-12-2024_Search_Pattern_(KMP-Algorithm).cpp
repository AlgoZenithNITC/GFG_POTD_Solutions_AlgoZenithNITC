class Solution {
  private:
    vector<int> computePrefix(string &pat){
        int n = pat.size(), k=0, i=1;
        vector<int> pre(n,0);
        while (i < pat.length()) {
            if (pat[i] == pat[k]) {
                k++;
                pre[i] = k;
                i++;
            }else{
                if (k != 0) {
                    k = pre[k - 1];
                }else{
                    pre[i] = 0;
                    i++;
                }
            }
        }
        return pre;
    }
  public:
    vector<int> search(string& pat, string& txt) {
        int n = txt.size(), m = pat.size(), i = 0, j = 0;
        vector<int> pre = computePrefix(pat), ans;
        while (i < n){
            if (txt[i] == pat[j]){
                i++; j++;
                if (j == m){
                    ans.push_back(i - j);
                    j = pre[j - 1];
                }
            }else{
                if (j != 0) {j = pre[j - 1];}
                else {i++;}
            }
        }
        return ans;
    }
};

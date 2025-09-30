class Solution {
  public:
    void f(string str, vector<string> &result,int  n){
        if(str.length() == n){
            result.push_back(str);
            return;
        }
        str.push_back('0');
        f(str, result, n);
        str.pop_back();
        str.push_back('1');
        f(str, result, n);
        
    }
    vector<string> binstr(int n) {
        // code here
        vector<string> result;
        string str;
        f(str, result, n);
        return result;
        
    }
};

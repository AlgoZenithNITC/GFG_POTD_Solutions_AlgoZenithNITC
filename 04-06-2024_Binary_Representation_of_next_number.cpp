class Solution {
    public:
    string binaryNextNumber(string s) {
        // code here.
        int n = s.length(), i;
        string ans = "";
        for(i = n-1; i >= 0; i--){
            if(s[i] == '1'){
                s[i] = '0';
            }
            else{
                s[i] = '1';
                break;
            }
        }
        if(i < 0){
            s = '1' + s;
        }
        else{
            i = 0;
            while(s[i] == '0'){
                i++;
            }
            s = s.substr(i, n);
        }
        return s;
    }
};

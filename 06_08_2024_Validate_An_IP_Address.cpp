class Solution {
  public:
    int isValid(string str) {
        // code here
        int n = str.length();
        int i = 0;
        int segments = 0;
        while (i < n) {
            string num = "";
            while (i < n && str[i] != '.') {
                if (!isdigit(str[i])) return false;
                num += str[i];
                i++;
            }
            if (num.empty() || (num[0] == '0' && num.length() > 1) || stoi(num) < 0 || stoi(num) > 255) {
                return false;
            }
            segments++;
            i++;
        }
        return segments == 4;
    }
};

string longestPalindrome(string &s) {
    // code here
    int n = s.size();
    int begin, end, len = 0;
    string ans;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j <= 1; j++){
            int x = i;  //Case of odd length
            int y = i+j; //Case of even length
            
            while(x >= 0 && y < n && s[x] == s[y]){
                int currLen = y - x + 1;
                if(currLen > len){
                    begin = x;
                    end = y;
                    len = currLen;
                }
                x--;
                y++;
            }
        }
    }
    
    while(begin <= end){
        ans += s[begin];
        begin++;
    }
    
    return ans;
}

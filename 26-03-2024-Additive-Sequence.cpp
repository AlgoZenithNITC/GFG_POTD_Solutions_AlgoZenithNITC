// User function template for C++
class Solution {
  public:
    bool isAdditiveSequence(string str) {
        // Your code here
           int n = str.size();
        if(n<3)
            return 0;
            
        string ans,s1;
        
        for(int i=0;i<min(n-1,10);i++){
            s1.push_back(str[i]);
            string s2 = "";
            for(int j=i+1;j<min(n,10);j++){
                s2.push_back(str[j]);
                ans = s1+s2;
                int a = stoi(s1);
                int b = stoi(s2);
                while(ans.size()<n){
                    int sum = a+b;
                    string s = to_string(sum);
                    if(n-ans.size() < s.size())
                        break;
                    ans += s;
                    a=b;
                    b=sum;
                    if(ans == str)
                        return 1;
                }
            }
        }
        
        return 0;
    }
};

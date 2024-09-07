// User function Template for C++

class Solution {
  public:
    long long findNth(long long n) {
        // code here.
        if(n<9) return n;
        vector<int> temp;
        
        while(n>=9){
            int rm = n%9;
            temp.push_back(rm);
            n/=9;
            if(n<9){
                temp.push_back(n);
            }
        }
        long long ans =0;
        
        for(int i=temp.size()-1;i>=0;i--){
            ans=ans*10+temp[i];
        }
        
        return ans ;
    }
};

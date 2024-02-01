
class Solution{
  public:

    int atoi(string s) {
        
        int n = s.length(),sum=0,k=1;
        
        for(int i=n-1;i>=1;i--){
            if(s[i]>='0'&&s[i]<='9'){
              int temp = s[i]-'0';
              sum+=(k*temp);
              k*=10;
            }else{
                return -1;
            }
        }
        
        if(s[0]=='+'){
            return sum;
        }else if(s[0]=='-'){
            return (0-sum);
        }else if(s[0]>='0'&&s[0]<='9'){
            int temp = s[0]-'0';
            sum+=(k*temp);
            return sum;
        }else{
            return -1;
        }
    }
};

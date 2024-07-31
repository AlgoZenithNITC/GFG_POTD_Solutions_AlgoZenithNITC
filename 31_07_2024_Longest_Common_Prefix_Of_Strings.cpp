// User function template for C++

class Solution {
  public:
    
    string LCP(string& str1, string&str2){
        string str;
        int i=0;
        int mini = min(str1.size(),str2.size());
        
        for(int i=0;i<mini;i++){
            if(str1[i] != str2[i]){
                break;
            }
            str.push_back(str1[i]);
        }
        
        return str;
    }

    string longestCommonPrefix(vector<string> arr) {
        if(arr.size()==0)return "-1";
        if(arr.size()==1)return arr[0];
        
        string temp = LCP(arr[0],arr[1]);
        
        for(int i=2;i<arr.size();i++){
            temp=LCP(temp,arr[i]);
        }
        
        return temp.empty() ? "-1" : temp;
    }
};

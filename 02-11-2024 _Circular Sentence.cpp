class Solution {
public:
    bool isCircularSentence(string s) {
        for(int i=0;i<s.size();i++){
            if(s[i]==' '&&s[i-1]!=s[i+1]){
                return false;
            }// checking for circular substring condition
        }
        if(s[0]!=s[s.size()-1]){//checking for circular whole string condition
            return false;
        }
        return true;
    }
};
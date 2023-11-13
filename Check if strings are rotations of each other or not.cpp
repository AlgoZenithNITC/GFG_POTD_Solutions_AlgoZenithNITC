class Solution{
    public:
    bool areRotations(string s1,string s2){
        return (s1 + s1).find(s2) != string::npos;
    }
};

#include<bits/stdc++.h>
class solution
{
    public:

        bool areAnagrams(string& s1, string& s2)
        {
           sort(s1.begin(),s1.end());
           sort(s2.begin(),s2.end());

           return (s1==s2);
        }
        
        

};
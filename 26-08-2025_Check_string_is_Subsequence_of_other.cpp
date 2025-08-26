#include <iostream>
#include <string>
using namespace std;

bool isSubSeqRec(string& s1, string& s2, int m, int n){
    // Base Cases
    if (m == 0)
        return true;
    if (n == 0)
        return false;

    // If last characters match
    if (s1[m - 1] == s2[n - 1])
        return isSubSeqRec(s1, s2, m - 1, n - 1);

    // If last characters don't match
    return isSubSeqRec(s1, s2, m, n - 1);
}

bool isSubSeq(string& s1, string& s2){
    int m = s1.length();
    int n = s2.length();
    if (m > n) return false;
    return isSubSeqRec(s1, s2, m, n);
}

int main(){
    string s1 = "gksrek";
    string s2 = "geeksforgeeks";
    if (isSubSeq(s1, s2))
        cout << "true";
    else
        cout << "false";
    return 0;
}
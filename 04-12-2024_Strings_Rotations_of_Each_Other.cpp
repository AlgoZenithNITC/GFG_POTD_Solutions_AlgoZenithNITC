vector<int> LPS(string &s){
    int n = s.length();
    vector <int> arr(n, 0);
    
    for(int i = 1; i < n; i++){
        int j = arr[i-1];

        while(j > 0 && s[i] != s[j])
            j = arr[j-1];  
                                    
        if(s[i] == s[j])
            j++;

        arr[i] = j;
    }
    
    return arr;
}

bool areRotations(string &s1, string &s2) {
    string s1_2 = s1+s1;
    int n = s1_2.length();
    
    //since find() function in C++ stl library is slow, we have
    //to implement our own string search KMP algorithm
    
    vector <int> arr = LPS(s2);
    
    int j = 0;
    for(int i = 0; i < n; i++){
        while(j > 0 && s1_2[i] != s2[j])
            j = arr[j-1];
        if(s1_2[i] == s2[j])
            j++;
        if(j == s2.length()){
            return true;
        }
    }
        
    return false;
}

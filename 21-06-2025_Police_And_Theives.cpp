int catchThieves(vector<char> &arr, int k) {
    // Code here
    int n = arr.size();
    int ans = 0;
    int i = 0, j = 0;
    while(i < n && j < n){
        while(i < n && arr[i] == 'T')
            i++;
        while(j < n && arr[j] == 'P')
            j++;
            
        if(i < n && j < n && abs(i - j) <= k){
            ans++;
            i++;
            j++;
        }
        else if(i < n && i < j)
            i++;
        else if(j < n && j < i)
            j++;
    }
    
    return ans;
}

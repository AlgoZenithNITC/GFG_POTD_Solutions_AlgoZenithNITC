vector<int> alternateSort(vector<int>& arr) {
    sort(arr.begin(), arr.end());
    int n = arr.size();
    
    int l = 0, r = n-1;
    
    vector<int> ans(n);
    int flag = 1;
    
    for(int i = 0; i < n; i++){
        if(flag)
            ans[i] = arr[r--];
        else
            ans[i] = arr[l++];
        flag ^= 1;
    }
    
    return ans;
}

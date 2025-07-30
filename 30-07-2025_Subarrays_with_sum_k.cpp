int cntSubarrays(vector<int> &arr, int k) {
    int n = arr.size();
    map<int, int> mp;
    int sum = 0;
    int count = 0;
    mp[0] = 1; 
    for (int i = 0; i < n; i++) {
        sum+=arr[i];

        if (mp.find(sum - k) != mp.end()) {
            count+=mp[sum - k];
        }

        mp[sum]++;
    }

    return count;
}

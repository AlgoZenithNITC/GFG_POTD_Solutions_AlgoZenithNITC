int minPlatform(vector<int> &arr, vector<int>& dep) {
    int n = arr.size();
    int res = 0;

    // Run a nested for-loop to find the overlap
    for (int i = 0; i < n; i++) {

        // Initially one platform is needed
        int cnt = 1;
        for (int j = 0; j < n; j++) {
            if (i != j)
                
                // Increment cnt if trains have overlapping
                // time.
                if (arr[i] >= arr[j] && dep[j] >= arr[i])
                    cnt++;
        }

        // Update the result
        res = max(cnt, res);
    }
    return res;
}
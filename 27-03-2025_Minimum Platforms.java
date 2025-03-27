class GfG {

    // Function to find the minimum 
    // number of platforms required
    static int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        int res = 0;

        // Run a nested for-loop to find the overlap
        for (int i = 0; i < n; i++) {

            // Initially one platform is needed
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (i != j)

                    // Increment cnt if trains have overlapping
                    // time.
                    if (arr[i] >= arr[j] && dep[j] >= arr[i]) {
                        cnt++;
                    }
            }

            // Update the result
            res = Math.max(cnt, res);
        }
        return res;
    }

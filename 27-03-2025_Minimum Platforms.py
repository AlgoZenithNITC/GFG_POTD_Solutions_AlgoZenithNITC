def minPlatform(arr, dep):
    n = len(arr)
    res = 0

    # Run a nested for-loop to find the overlap
    for i in range(n):

        # Initially one platform is needed
        cnt = 1
        for j in range(n):
            if i != j:

                # Increment cnt if trains have overlapping
                # time.
                if arr[i] >= arr[j] and dep[j] >= arr[i]:
                    cnt += 1

        # Update the result
        res = max(cnt, res)
    return res
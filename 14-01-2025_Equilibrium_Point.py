def equilibriumPoint(arr):
    prefSum = 0
    total = sum(arr)

    # Iterate pivot over all the elements of the array
    for pivot in range(len(arr)):
        suffSum = total - prefSum - arr[pivot]
        if prefSum == suffSum:
            return pivot
        prefSum += arr[pivot]

    # There is no equilibrium point
    return -1
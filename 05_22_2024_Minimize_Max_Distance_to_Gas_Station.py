class Solution:

    # Function to find the smallest maximum distance
    def findSmallestMaxDist(self, stations, K):
        left, right = 1e-6, stations[-1] - stations[0]
        while left + 1e-6 < right:
            mid = (left + right) / 2
            count = 0

            # Counting the number of stations that can be added with the current maximum distance
            for a, b in zip(stations, stations[1:]):
                count += math.ceil((b - a) / mid) - 1

            # Updating the left or right values based on the count
            if count > K:
                left = mid
            else:
                right = mid
        return right

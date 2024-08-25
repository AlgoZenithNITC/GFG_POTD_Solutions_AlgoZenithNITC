#Back-end complete function Template for Python 3


class Solution:

    def count(self, x, b, N, NoOfb):

        #If x is 0, then there can't be any value in b[]
        #such that x^b[val]>b[val]^x.
        if (not x):
            return x

        #If x is 1, then the number of pair is equal to number of zeroes in b[].
        if (x == 1):
            return NoOfb[0]

        #We work with logic that if x<y then x^y is greater than y^x.
        #Finding number of elements in b[] with value greater than x.

        #bisect.bisect_right() gets address of first
        #element greater than x in b[].
        index = bisect.bisect_right(b, x)
        ans = 0
        if (index < N and b[index] > x):
            #Updating number of pairs.
            ans += N - index

        #If we have reached here, then x must be greater than 1.
        #Increasing number of pairs for b=0 and b=1 .
        ans += (NoOfb[0] + NoOfb[1])

        #Decreasing number of pairs for exception where x=2 and (b=4 or b=3).
        if (x == 2):
            ans -= NoOfb[3] + NoOfb[4]

        #Increasing number of pairs for exception where x=3 and b=2.
        if (x == 3):
            ans += NoOfb[2]

        #returning number of pairs.
        return ans

    #Function to count number of pairs such that x^y is greater than y^x.
    def countPairs(self, arr, brr):
        M = len(arr)
        N = len(brr)
        #Array to store counts of 0, 1, 2, 3 and 4 present in array b.
        NoOfb = [0, 0, 0, 0, 0]
        #Storing the count in array if b[i]<5.
        for i in range(N):
            if (brr[i] < 5):
                NoOfb[brr[i]] += 1

        #Sorting b[] so that we can do binary search on it later on.
        brr.sort()

        total_pairs = 0

        #Taking every element of a[] and counting pairs with it.
        for i in range(M):
            total_pairs += self.count(arr[i], brr, N, NoOfb)

        #returning number of pairs.
        return total_pairs

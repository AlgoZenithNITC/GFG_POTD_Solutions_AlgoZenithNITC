#User function Template for python3
class Solution:

    def matchPairs(self, n, nuts, bolts):
        # Character to index mapping dictionary
        dic = {'!': 0, '#': 1, '$': 2, '%': 3, '&': 4, '*': 5, '?': 6, '@': 7, '^': 8}
        
        # Result array initialized to zeros with length 9 (since there are 9 unique characters)
        res = [0] * 9
        
        # Index for updating nuts and bolts arrays
        j = 0
        
        # Place each nut in the res array based on its index from the dictionary
        for nut in nuts:
            res[dic[nut]] = nut
        
        # Rebuild nuts and bolts arrays with sorted order from the res array
        for item in res:
            if item != 0:  # Ignore the placeholders (zeros)
                nuts[j] = item
                bolts[j] = item
                j += 1		# code here


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n = int(input())
        nuts = list(map(str, input().strip().split()))
        bolts = list(map(str, input().strip().split()))
        ob = Solution()
        ob.matchPairs(n, nuts, bolts)
        for x in nuts:
            print(x, end=" ")
        print()
        for x in bolts:
            print(x, end=" ")
        print()
        tc -= 1

# } Driver Code Ends
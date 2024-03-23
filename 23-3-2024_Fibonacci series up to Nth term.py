#User function Template for python3

class Solution:
    def series(self, n):
        # Code here
        
        ans = []
        a = 0
        b = 1
        ans.append(a)
        ans.append(b)
        mod = 10**9 + 7
        for i in range(2, n+1):
            sum = (a + b) % mod
            a = b
            b = sum
            ans.append(sum)
        return ans




#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        N = int(input())
        ob = Solution()
        result = ob.series(N)
        print(*result)
# } Driver Code Ends
#User function Template for python3

class Solution:
    def kPalindrome(self, st, n, k):
        prev=[0]*len(st)
        for i in range(len(st)-1,-1,-1):
            curr=[0]*len(st)
            curr[i]=1
            for j in range(i+1,len(st)):
                curr[j]=max(prev[j],curr[j-1])
                if st[i]==st[j]:
                    curr[j]=max(curr[j],2+prev[j-1])
            prev=[l for l in curr]
        return 1 if len(st)-curr[len(st)-1]<=k else 0
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        arr = input().split()
        n = int(arr[0])
        k = int(arr[1])
        str = input()

        ob = Solution()
        print(ob.kPalindrome(str, n, k))

# } Driver Code Ends
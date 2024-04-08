#User function Template for python3


#Function to find the maximum possible amount of money we can win.
class Solution:
    def optimalStrategyOfGame(self,n, arr):
        # code here
        table = [[0 for i in range(n)]
                 for i in range(n)]

        #filling table using above recursive formula. Note that the 
        #table is filled in diagonal fashion, from diagonal elements 
        #to table[0][n-1] which is the result.
        for gap in range(n):
            for j in range(gap, n):
                i = j - gap

                #Here x is value of table[i + 2][j], y istable[i + 1][j - 1] 
                #and  z is table[i][j - 2] in above recursive formula.
            
                x = 0
                if ((i + 2) <= j):
                    x = table[i + 2][j]
                y = 0
                if ((i + 1) <= (j - 1)):
                    y = table[i + 1][j - 1]
                z = 0
                if (i <= (j - 2)):
                    z = table[i][j - 2]
                table[i][j] = max(arr[i] + min(x, y),
                                  arr[j] + min(y, z))
                              
        #returning the result.
        return table[0][n - 1]


#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

# Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        n = int(input())
        arr = list(map(int,input().strip().split()))
        ob = Solution()
        print(ob.optimalStrategyOfGame(n,arr))

# } Driver Code Ends

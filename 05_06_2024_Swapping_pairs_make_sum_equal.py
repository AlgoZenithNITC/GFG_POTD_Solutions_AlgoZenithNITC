class Solution:
    def findSwapValues(self,a, n, b, m):
        # Your code goes here
        a_sum=sum(a)
        b_sum=sum(b)
        if (a_sum-b_sum)%2!=0:
            return -1
        diff=(a_sum-b_sum)//2
        a_set=set(a)
        for i in b:
            if (i+diff) in a_set:
                return 1
        return -1

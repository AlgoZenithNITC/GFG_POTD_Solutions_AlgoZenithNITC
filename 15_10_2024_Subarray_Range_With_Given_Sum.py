#User function Template for python3

class Solution:
    
    #Complete this fuction
    #Function to count the number of subarrays which adds to the given sum.
    def subArraySum(self,arr, tar):
        hash = {0 : 1}
        res = c_sum = 0
        for i in range(len(arr)):
            c_sum += arr[i]
            if c_sum - tar in hash:
                res += hash[c_sum - tar]
            hash[c_sum] = hash.get(c_sum, 0) + 1
        
        return res
        
        

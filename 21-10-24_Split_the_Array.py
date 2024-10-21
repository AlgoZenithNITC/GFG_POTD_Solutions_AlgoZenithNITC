class Solution:
	def countgroup(self,arr): 
	   
        total_xor = arr[0]
        n = len(arr)
    
        for i in range(1, n):
            total_xor ^= arr[i]
    
        if total_xor != 0:
            return 0
    
        return (1 << (n - 1)) - 1

		


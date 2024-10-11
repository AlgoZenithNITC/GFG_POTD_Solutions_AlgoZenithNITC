class Solution:
    def rearrange(self, ar):
        #Code here
        n = len(ar)
        for i in range(n):
            for j in range(n):
    
                # Check is any ar[j]
                # exists such that
                # ar[j] is equal to i
                if (ar[j] == i):
                    ar[j], ar[i] = ar[i], ar[j]
    
        # Iterate over array
        for i in range(n):
            
            # If not present
            if (ar[i] != i):
                ar[i] = -1
                
        return ar

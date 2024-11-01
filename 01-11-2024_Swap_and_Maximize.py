class Solution:
    def maxSum(self,arr):

        arr.sort()
        
   
        final_arrangement = []
        
        start = 0
        end = len(arr) - 1
        
      
        while start <= end:
            if start != end:
                final_arrangement.append(arr[start])
                final_arrangement.append(arr[end])
            else:
              
                final_arrangement.append(arr[start])
            start += 1
            end -= 1
        

        total_sum = 0
        for i in range(0,len(final_arrangement) - 1):
            total_sum += abs(final_arrangement[i + 1] - final_arrangement[i])
        
        total_sum += abs(final_arrangement[0] - final_arrangement[-1])
        
        return total_sum

class Solution:
    
    def getSingle(self,arr):
        # code here
        Hash=dict()
        n = len(arr)
     
        # Putting all elements into the HashMap 
        for i in range(n):
            Hash[arr[i]]=Hash.get(arr[i],0) + 1;
        
        # Iterate through HashMap to check an element
        # occurring odd number of times and return it
        for i in Hash:
    
            if(Hash[i]% 2 != 0):
                return i
        return -1

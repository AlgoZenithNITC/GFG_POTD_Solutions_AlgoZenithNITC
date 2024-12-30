class Solution:    
    #Function to return the count of number of elements in union of two arrays.
    def findUnion(self, a, b):
        # code here
        # Using a set to store unique elements
        union_set = set()
        
        # Add all elements from array a to the set
        for element in a:
            union_set.add(element)
        
        # Add all elements from array b to the set
        for element in b:
            union_set.add(element)
        
        # Return the size of the set as the count of distinct elements
        return len(union_set)

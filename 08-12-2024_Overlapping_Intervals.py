class Solution:
	def mergeOverlap(self, arr):
		#Code here
		arr.sort()  # Sort the array of intervals
        n = len(arr)
        res = []
        i = 0
        
        while i < n:
            temp = [0, 0]
            temp[0] = arr[i][0]
            temp[1] = arr[i][1]
            
            while i + 1 < n and temp[1] >= arr[i + 1][0]:
                temp[1] = max(temp[1], arr[i + 1][1])
                i += 1
            
            res.append(temp)
            i += 1
            
        return res
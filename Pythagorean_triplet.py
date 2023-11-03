class Solution:
	def checkTriplet(self,arr, n):
	    l = []
	    for i in arr:
	        l.append(i*i)
        l = list(set(l))
        for i in range(len(l)):
            for j in range(i,-1,-1):
                py_sum = l[i]+l[j]
                if py_sum in l:
                   return True
        return False

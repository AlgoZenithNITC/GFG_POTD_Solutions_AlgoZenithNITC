class Solution:
    def modifyAndRearrangeArr (self, arr) : 
        for i in range(1,len(arr)):
            if (arr[i]==arr[i-1]):
                arr[i-1]=arr[i-1]*2
                arr[i]=0
        i=0
        while (i<len(arr)):
            if (arr[i]==0):
                arr.remove(0)
                arr.append(0)
            i=i+1
        return arr

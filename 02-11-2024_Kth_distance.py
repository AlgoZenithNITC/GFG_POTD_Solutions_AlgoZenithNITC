class Solution:
    def checkDuplicatesWithinK(self, arr, k):
        dict={}
        for i in range(0,len(arr)):
            if (arr[i] in dict and i-dict[arr[i]]<=k):
                return 1
            dict[arr[i]]=i
        return 0

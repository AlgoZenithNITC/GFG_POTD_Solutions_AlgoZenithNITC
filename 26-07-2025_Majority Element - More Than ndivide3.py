class Solution:
    def findMajority(self, arr):
        value = len(arr) // 3
        count_map = {}
        
        for num in arr:
            count_map[num] = count_map.get(num, 0) + 1
            
        res = []
        for key, count in count_map.items():
            if count > value:
                res.append(key)
        res.sort()        
        return res

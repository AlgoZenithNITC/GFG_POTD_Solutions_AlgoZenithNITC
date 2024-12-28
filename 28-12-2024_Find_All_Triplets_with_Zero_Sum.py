class Solution:
    def findTriplets(self, arr):
        result_set = set()
        
        n = len(arr)
        
        sum_with_pair = {}
        
        for i in range(n):
            for j in range(i + 1, n):
                total = arr[i] + arr[j]
                
                if total not in sum_with_pair:
                    sum_with_pair[total] = []
                sum_with_pair[total].append((i, j))
        
        for i in range(n):
            complement = -arr[i]
            
            if complement in sum_with_pair:
                for pair in sum_with_pair[complement]:
                    if i != pair[0] and i != pair[1]:
                        triplet = sorted([i, pair[0], pair[1]])
                        result_set.add(tuple(triplet))
        
        return [list(triplet) for triplet in result_set]

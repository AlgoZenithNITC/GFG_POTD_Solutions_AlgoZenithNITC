def count_splits(arr, max_sum):
            splits = 1
            current_sum = 0
        
            for num in arr:
                current_sum += num
                if current_sum > max_sum:
                    splits += 1
                    current_sum = num
        
            return splits

        
        low, high = max(arr), sum(arr)

        while low < high:
            mid = (low + high) // 2
            splits = count_splits(arr, mid)
    
            if splits > k:
                low = mid + 1
            else:
                high = mid
    
        return low

def findPages(self, arr, k):
        #code here
        # If there are fewer books than students, allocation is not possible
        if len(arr) < k:
            return -1
        
        # Helper function to check feasibility of allocation
        def isPossible(arr, n, k, maxPages):
            student_count = 1
            current_pages = 0
            
            for pages in arr:
                if current_pages + pages > maxPages:
                    # Allocate books to next student
                    student_count += 1
                    current_pages = pages
                    
                    # If students required exceed k, return False
                    if student_count > k:
                        return False
                else:
                    current_pages += pages
            
            return True
        
        # Binary search over the range of possible max pages
        low, high = max(arr), sum(arr)
        result = high
        
        while low <= high:
            mid = (low + high) // 2
            if isPossible(arr, len(arr), k, mid):
                result = mid  # Update result and try for a smaller max
                high = mid - 1
            else:
                low = mid + 1
        
        return result
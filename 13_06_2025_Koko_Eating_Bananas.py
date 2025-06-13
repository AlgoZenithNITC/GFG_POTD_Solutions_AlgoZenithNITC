class Solution:
    def kokoEat(self,arr,k):
        # Code here
        left, right = 1, max(arr)
        
        def can_finish(speed):
            hours = 0
            for bananas in arr:
                hours += (bananas + speed - 1) // speed
            return hours <= k
        
        while left < right:
            mid = (left + right) // 2
            if can_finish(mid):
                right = mid
            else:
                left = mid + 1 
        
        return left

class Solution:
    def countLessEq(self, a, b):
        # code here
    
        max_val = max(max(a), max(b))  # Step 1
    
        freq = [0] * (max_val + 2)     # Step 2
        for num in b:
            freq[num] += 1

    # Step 3: Build prefix sum
        for i in range(1, len(freq)):
            freq[i] += freq[i - 1]

    # Step 4: Query prefix sum
        result = [freq[x] for x in a]
        return result

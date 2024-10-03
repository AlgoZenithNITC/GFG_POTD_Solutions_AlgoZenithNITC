class Solution:
    # Function to find the majority elements in the array
    def findMajority(self, nums):
        n = len(nums)
        num1, num2, c1, c2 = 0, 0, 0, 0
        res = []

        # Finding the two most frequent numbers using Boyer-Moore algorithm
        for x in nums:
            if x == num1:
                c1 += 1
            elif x == num2:
                c2 += 1
            elif c1 == 0:
                num1 = x
                c1 = 1
            elif c2 == 0:
                num2 = x
                c2 = 1
            else:
                c1 -= 1
                c2 -= 1

        c1, c2 = 0, 0
        # Counting the occurrences of num1 and num2
        for x in nums:
            if x == num1:
                c1 += 1
            elif x == num2:
                c2 += 1

        # Checking if num1 and num2 are majority elements
        if c1 > n / 3:
            res.append(num1)
        if c2 > n / 3:
            res.append(num2)
        res.sort()
        # If no majority elements, add -1 to the result list
        if len(res) == 0:
            res.append(-1)
        return res

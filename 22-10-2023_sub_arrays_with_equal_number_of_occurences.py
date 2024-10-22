class Solution:
    def sameOccurrence(self, arr, x, y):
        dict1 = {0: 1}
        count = 0
        output = 0
        for num in arr:
            if num == x:
                count += 1
            elif num == y:
                count -= 1
            if count in dict1:
                output += dict1[count]
            dict1[count] = dict1.get(count, 0) + 1
        return output

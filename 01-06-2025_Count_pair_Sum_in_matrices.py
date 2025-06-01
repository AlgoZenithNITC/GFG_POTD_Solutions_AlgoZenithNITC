class Solution:
    def countPairs(self, mat1, mat2, x):
        count = 0
        n = len(mat1)
        elements = set()

        # Insert all elements of mat2 into the set
        for i in range(n):
            for j in range(n):
                elements.add(mat2[i][j])

        # For each element in mat1, check if x - element exists in mat2
        for i in range(n):
            for j in range(n):
                if (x - mat1[i][j]) in elements:
                    count += 1

        return count

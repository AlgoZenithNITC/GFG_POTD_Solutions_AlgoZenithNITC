class Solution:

    def rowWithMax1s(self, arr):
        n = len(arr)
        m = len(arr[0])
        # initializing row and column index
        r = 0
        c = m - 1
        # initializing max_row_index as -1
        max_row_index = -1

        # looping through the matrix
        while r < n and c >= 0:
            # checking if current element is 1
            if arr[r][c] == 1:
                max_row_index = r
                c -= 1
            # if current element is 0
            else:
                r += 1

        # returning the row index with maximum number of 1s
        return max_row_index

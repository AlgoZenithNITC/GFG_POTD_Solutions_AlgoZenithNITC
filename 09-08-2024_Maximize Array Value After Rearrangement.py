
class Solution:

    #Function to maximize the sum
    #by rearranging the array elements.
    def Maximize(self, arr):

        n = len(arr)
        arr.sort()  #sorting the array

        mod = 1000000007  #taking modulo for large values

        s = 0  #variable to store the sum

        for i in range(n):
            s += arr[
                i] * i  #calculating the sum of array elements multiplied by their index
            s = s % mod  #taking modulo to avoid large sum value

        return s % mod  #returning the final sum after taking modulo.

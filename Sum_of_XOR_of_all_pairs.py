class Solution:
    def sumXOR(self, arr, n):
        sum = 0;
        n = len(arr)
        for bit in range(32):
            set_bits = 0
            unset_bits = 0
            for j in range(n):
                if(arr[j] & (1 << bit)) != 0:
                    set_bits += 1
                else:
                    unset_bits += 1
            possible_combinations = set_bits*unset_bits
            sum += possible_combinations*(1 << bit)
        return sum

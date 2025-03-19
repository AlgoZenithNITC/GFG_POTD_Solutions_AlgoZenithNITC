class Solution:
    def maxProfitUtil(self, i, k, buy, prices):
        if k <= 0 or i >= len(prices):
            return 0

        result = 0
        profit = 0

        if buy:
            profit = self.maxProfitUtil(i + 1, k, 0, prices) - prices[i]
            result = max(result, profit)
        else:
            profit = prices[i] + self.maxProfitUtil(i + 1, k - 1, 1, prices)
            result = max(result, profit)

        profit = self.maxProfitUtil(i + 1, k, buy, prices)
        return max(result, profit)

   
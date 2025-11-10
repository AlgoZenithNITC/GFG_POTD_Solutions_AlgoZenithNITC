class Solution:
    def maxProfit(self, arr):
        n = len(arr)

        buy = -arr[0]   # max profit if we buy a stock today
        sell = 0        # max profit if we sell today
        skip = 0        # max profit if we skip today

        for i in range(1, n):
            price = arr[i]

            prvBuy = buy
            prvSell = sell
            prvSkip = skip

            buy = max(prvBuy, prvSkip - price)
            sell = prvBuy + price
            skip = max(prvSkip, prvSell)

        return max(sell, skip)

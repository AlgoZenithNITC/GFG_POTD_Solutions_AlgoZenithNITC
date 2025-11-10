class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;

        int buy = -arr[0];  // max profit if we buy a stock today
        int sell = 0;       // max profit if we sell today
        int skip = 0;       // max profit if we skip today

        for (int i = 1; i < n; i++) {
            int price = arr[i];

            int prvBuy = buy;
            int prvSell = sell;
            int prvSkip = skip;

            buy = Math.max(prvBuy, prvSkip - price);
            sell = prvBuy + price;
            skip = Math.max(prvSkip, prvSell);
        }

        return Math.max(sell, skip);
    }
}

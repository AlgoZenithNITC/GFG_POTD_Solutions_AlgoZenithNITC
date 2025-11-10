class Solution {
  public:
    int maxProfit(vector<int>& arr) {
        // code here
        int n = arr.size();
        
        // base cases
        int buy = -arr[0];  // maximum profit if we buy a stock today
        int sell = 0;   // maximum profit if we sell our holding today
        int skip = 0;   // maximum profit if we skip trade today
        
        for (int i=1; i<n; i++) {
            int price = arr[i];
            
            int prvBuy = buy;
            int prvSell = sell;
            int prvSkip = skip;
            
            buy = max(prvBuy, prvSkip-price);  // maximum of previous buying or today's buying
            sell = prvBuy+price;    // profit after selling today
            skip = max(prvSkip, prvSell);   // max of previous skipping or skipping after yesterday sell
        }
        
        return max(sell, skip);
    }
};
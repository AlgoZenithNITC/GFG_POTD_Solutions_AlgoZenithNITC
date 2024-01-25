class Solution{
    public:
    static bool comp(Item &a, Item &b){
        return 1.0*a.value/a.weight > 1.0*b.value/b.weight;
    }
    double fractionalKnapsack(int W, Item arr[], int n){
        double profit = 0;
        sort(arr, arr + n, comp);
        for(int i = 0; i < n and W != 0; i++){
            profit += arr[i].value*(1.0*min(arr[i].weight, W)/arr[i].weight);
            W -= min(arr[i].weight, W);
        }
        return profit;
    }
};

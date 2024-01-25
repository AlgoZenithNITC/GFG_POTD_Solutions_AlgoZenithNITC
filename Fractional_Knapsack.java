class itemComparator implements Comparator<Item>{
    public int compare(Item a, Item b){
        double r1 = (double)a.value / a.weight;
        double r2 = (double)b.value / b.weight;
        if(r1 > r2){
            return -1;
        }else if(r1 < r2){
            return 1;
        }
        return 0;
    }
}

class Solution{
    double fractionalKnapsack(int W, Item arr[], int n){
        Arrays.sort(arr, new itemComparator());
        int curWeight = 0;
        double finalvalue = 0.0;
        for(int i = 0; i < n; i++){
            if(curWeight + arr[i].weight <= W){
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }else{
                int remain = W - curWeight;
                finalvalue += arr[i].value * ((double) remain / arr[i].weight);
                break;
            }
        }
        return finalvalue;
    }
}

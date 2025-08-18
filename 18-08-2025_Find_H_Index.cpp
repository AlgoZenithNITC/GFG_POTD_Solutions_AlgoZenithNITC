bool check(vector<int> &arr, int H){
    int count = 0;
    for(int x: arr){
        if(x >= H) count++;
    }
    
    if(count >= H) 
        return true;
    return false;
}
int hIndex(vector<int>& citations) {
    // code here
    int low = 1, high = *max_element(citations.begin(), citations.end());
    
    while(low <= high){
        int mid = low + (high - low)/2;
        
        if(check(citations, mid)){
            low = mid + 1;
        }
        else{
            high = mid - 1;
        }
    }
    
    return high;
}

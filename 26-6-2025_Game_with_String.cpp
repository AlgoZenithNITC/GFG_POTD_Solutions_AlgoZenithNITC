class Solution {
  public:
    int minValue(string &s, int k) {
        // code here
        priority_queue<int>pq;
        vector <int> freq(26,0);
        for(int ch:s) 
            freq[ch-'a']++;
        for(int i=0;i<26;i++){
            if(freq[i]!=0)
                pq.push(freq[i]);
        }
        while(k--){
            int mx=pq.top();
            pq.pop();
            if(mx>0) mx--;
            if(mx>0) pq.push(mx);
        }
        int sum=0;
        while(!pq.empty()){
            sum+=(pq.top()* pq.top());
            pq.pop();
        }
        return sum;
    }
};
class Solution{
    int kSubstrConcat(int n, String s, int k){
        if(n%k != 0){
            return 0;
        }
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < n; i += k){
            hs.add(s.substring(i,i + k));
            if(hs.size() > 2){
                return 0;
            }
        }
        if(hs.size() == 2 || hs.size() == 1){
            return 1;
        }
        return 0; 
    }
}

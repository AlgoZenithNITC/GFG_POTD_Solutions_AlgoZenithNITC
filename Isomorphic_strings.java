class Solution{
    public static boolean areIsomorphic(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int n = s1.length(), used = 0;
        for(int i = 0; i < n; i++){
            if(map[s1.charAt(i) - 'a'] != -1) {
                if(map[s1.charAt(i) - 'a'] != s2.charAt(i) - 'a'){
                    return false;
                }
            }else{
                if((used >> (s2.charAt(i) - 'a') & 1) == 1){
                    return false;
                }else{
                    map[s1.charAt(i) - 'a'] = s2.charAt(i) - 'a';
                    used |= (1 << (s2.charAt(i) - 'a'));
                }
            }
        }
        return true;
    }
}

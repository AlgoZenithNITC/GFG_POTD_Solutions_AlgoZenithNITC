class Solution {
    public static int distinct(String s){
        HashMap<Character, Integer> mp = new HashMap<>();
        int total = 0;
        for(int i = 0; i < s.length(); i++){
            int present = total + 1;
            if(mp.containsKey(s.charAt(i))){
                total += (present - mp.get(s.charAt(i)));
            }else{
                total += present;
            }
            mp.put(s.charAt(i), present);
        } 
        return total;
    }
    public static String betterString(String str1, String str2){
        int distinct_one = distinct(str1);
        int distinct_two = distinct(str2);
        return distinct_one >= distinct_two ? str1 : str2;
    }
}

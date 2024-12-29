class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : a ){
            set.add(num);
        }
        for(int num : b){
            if(set.contains(num)){
                ans.add(num);
            }
        }
        return new ArrayList<>(ans);
    }
}

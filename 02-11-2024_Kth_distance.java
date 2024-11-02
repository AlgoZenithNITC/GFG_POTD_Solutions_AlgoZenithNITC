import java.util.HashMap;

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && i - map.get(arr[i]) <= k) {
                return true;
            }
            map.put(arr[i], i);
        }

        return false;
    }
}

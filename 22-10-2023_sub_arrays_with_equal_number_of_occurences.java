class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        Map<Integer, Integer> dict = new HashMap();
        int count = 0;
        int output = 0;
        dict.put(0, 1);
        for (int num: arr) {
            if (num == x) {
                count++;
            } else if (num == y) {
                count--;
            }
            if (dict.containsKey(count)) {
                output += dict.get(count);
            }
            dict.put(count, dict.getOrDefault(count, 0) + 1);
        }
        return output;
    }
}

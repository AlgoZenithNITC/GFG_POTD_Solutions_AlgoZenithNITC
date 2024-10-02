

class Solution {
    public int rotateDelete(List<Integer> arr) {
        int i = 1;
        int n = arr.size();
        while (i < (n / 2) + 1) {
            Collections.rotate(arr, 1);
            arr.remove(arr.size() - i);
            i++;
        }
        return arr.get(0);
    }

}

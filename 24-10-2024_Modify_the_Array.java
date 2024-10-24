class Solution {
    public void modifyAndRearrangeArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                arr[i - 1] = arr[i - 1] * 2;
                arr[i] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i]; 
            }
        }

        while (count < arr.length) {
            arr[count++] = 0;
        }
    }

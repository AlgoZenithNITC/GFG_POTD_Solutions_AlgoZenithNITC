public static ArrayList<Integer> alternateSort(int[] arr) {
      Arrays.sort(arr);
      int n = arr.length;
      
      int l = 0, r = n - 1;
      ArrayList<Integer> ans = new ArrayList<>();
      boolean flag = true;
      
      for (int i = 0; i < n; i++) {
          if (flag) {
              ans.add(arr[r--]);
          } else {
              ans.add(arr[l++]);
          }
          flag = !flag;
      }
      
      return ans;
  }
}

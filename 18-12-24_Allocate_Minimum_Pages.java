
class Solution {
       private boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int studentCount = 1;
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                studentCount++;
                currentPages = pages;

                // If students required exceed k, return false
                if (studentCount > k) {
                    return false;
                }
            } else {
                currentPages += pages;
            }
        }
        return true;
    }

    public int findPages(int[] arr, int k) {
        int n = arr.length;

        if (n < k) {
            return -1;
        }

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, mid)) {
                result = mid; // Update result and try for a smaller maximum
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution sol = new Solution();
            System.out.println(sol.findPages(arr, k));
        }
        sc.close();
    }
}

import java.util.*;

class Solution {
    private int find(List<Integer> arr, int i, int n) {
        int sum = 0;
        for (int j = i; j < n; j += 2) {
            sum += arr.get(j);
        }
        return sum;
    }

    public int maxValue(List<Integer> arr) {
        int n = arr.size();
        int w1 = find(arr, 0, n - 1);
        int w2 = find(arr, 1, n);
        return Math.max(w1, w2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        while (t-- > 0) {
            String input = scanner.nextLine();
            List<Integer> arr = new ArrayList<>();
            Scanner s2 = new Scanner(input);
            while (s2.hasNextInt()) {
                arr.add(s2.nextInt());
            }
            s2.close();

            Solution ob = new Solution();
            int res = ob.maxValue(arr);
            System.out.println(res);
            System.out.println("~");
        }

        scanner.close();
    }
}

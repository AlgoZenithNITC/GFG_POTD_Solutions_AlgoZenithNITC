import java.util.ArrayList;
import java.util.List;

class Solution {
    private int merge(List<Integer> arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr.get(left) <= arr.get(right)) {
                temp.add(arr.get(left));
                left++;
            } else {
                temp.add(arr.get(right));
                cnt += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr.get(left));
            left++;
        }

        while (right <= high) {
            temp.add(arr.get(right));
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr.set(i, temp.get(i - low));
        }
        return cnt;
    }

    private int mergeSort(List<Integer> arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    private void solve(List<Integer> inorder, Node root) {
        if (root == null) {
            return;
        }
        solve(inorder, root.left);
        inorder.add(root.data);
        solve(inorder, root.right);
    }

    public int pairsViolatingBST(int n, Node root) {
        List<Integer> inorder = new ArrayList<>();
        solve(inorder, root);
        int m = inorder.size();
        return mergeSort(inorder, 0, m - 1);
    }
}


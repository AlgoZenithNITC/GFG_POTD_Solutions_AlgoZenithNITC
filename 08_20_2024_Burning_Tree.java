

//User function Template for Java

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/

    private static class Pair {
        boolean found;
        int time;

        Pair(boolean found, int time) {
            this.found = found;
            this.time = time;
        }
    }

    private static Pair getTime(Node root, int target, int[] ans) {
        if (root == null) {
            return new Pair(false, 0);
        }

        Pair left = getTime(root.left, target, ans);
        Pair right = getTime(root.right, target, ans);

        if (!left.found && !right.found) {
            ans[0] = Math.max(ans[0], Math.max(left.time, right.time));
            int val = Math.max(left.time, right.time);
            if (root.data == target) {
                return new Pair(true, 1);
            }
            return new Pair(false, 1 + val);
        } else {
            ans[0] = Math.max(ans[0], left.time + right.time);
            if (left.found) {
                return new Pair(true, 1 + left.time);
            } else {
                return new Pair(true, 1 + right.time);
            }
        }
    }

    public static int minTime(Node root, int target) {
        int[] ans = new int[1];
        getTime(root, target, ans);
        return ans[0];
    }
}

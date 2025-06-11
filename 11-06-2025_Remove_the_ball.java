class Solution {
    public int findLength(List<Integer> color, List<Integer> radius) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < color.size(); i++) {
            int[] curr = {color.get(i), radius.get(i)};
            if (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[0] == curr[0] && top[1] == curr[1]) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(curr);
        }

        return stack.size();
    }
}

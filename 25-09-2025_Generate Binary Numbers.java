class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String curr = q.poll();
            result.add(curr);

            q.add(curr + "0");
            q.add(curr + "1");
        }
        return result;
    }
}

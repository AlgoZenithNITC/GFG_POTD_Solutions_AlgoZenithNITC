import java.util.*;

class Solution {
    public void dfs(int i, List<List<Integer>> adj, List<Integer> ans, Map<Integer, Boolean> visited) {
        ans.add(i);
        visited.put(i, true);
        for (int z : adj.get(i)) {
            if (!visited.getOrDefault(z, false)) {
                dfs(z, adj, ans, visited);
            }
        }
    }

    public List<Integer> dfs(List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        dfs(0, adj, ans, visited);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int V = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String line = scanner.nextLine();
                List<Integer> node = new ArrayList<>();
                if (!line.isEmpty()) {
                    for (String num : line.split(" ")) {
                        node.add(Integer.parseInt(num));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

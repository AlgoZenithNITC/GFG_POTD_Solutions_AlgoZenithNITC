class Solution {
    void dfs(int node, List<Integer>[] graph, int[] visited) {
        visited[node] = 1;
        for (int u : graph[node]) {
            if (visited[u] == 0)
                dfs(u, graph, visited);
        }
    }

    public int isCircle(List<String> words) {
        int n = words.size();
        List<Integer>[] graph = new ArrayList[26];
        List<Integer>[] transpose = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int len = words.get(i).length() - 1;
            graph[words.get(i).charAt(0) - 'a'].add(words.get(i).charAt(len) - 'a');
            transpose[words.get(i).charAt(len) - 'a'].add(words.get(i).charAt(0) - 'a');
        }

        int[] inDegree = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int u : graph[i])
                inDegree[u]++;
        }

        for (int i = 0; i < 26; i++) {
            if (graph[i].size() > 0 && inDegree[i] != graph[i].size())
                return 0;
        }

        int[] visited = new int[26];
        int start = 0;
        for (start = 0; start < 26; start++) {
            if (inDegree[start] > 0)
                break;
        }

        dfs(start, graph, visited);
        for (int i = 0; i < 26; i++) {
            if (graph[i].size() > 0 && visited[i] == 0)
                return 0;
        }

        for (int i = 0; i < 26; i++)
            visited[i] = 0;

        dfs(start, transpose, visited);

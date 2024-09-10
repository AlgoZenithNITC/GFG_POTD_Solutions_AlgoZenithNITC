class Solution {
public:
    void dfs(int node, vector<int> adj[], int visited[]) {
        visited[node] = 1;
        for (auto u : adj[node]) {
            if (!visited[u])
                dfs(u, adj, visited);
        }
    }

    int isCircle(vector<string> &words) {
        int n = words.size();
        vector<int> graph[26], transpose[26];

        for (int i = 0; i < n; i++) {
            int len = words[i].size() - 1;
            graph[words[i][0] - 'a'].emplace_back(words[i][len] - 'a');
            transpose[words[i][len] - 'a'].emplace_back(words[i][0] - 'a');
        }

        int inDegree[26] = {0};
        for (int i = 0; i < 26; i++) {
            for (auto u : graph[i])
                inDegree[u]++;
        }

        for (int i = 0; i < 26; i++) {
            if (graph[i].size() > 0 && inDegree[i] != graph[i].size())
                return 0;
        }

        int visited[26] = {0};
        int start;
        for (start = 0; start < 26; start++) {
            if (inDegree[start] > 0)
                break;
        }

        dfs(start, graph, visited);
        for (int i = 0; i < 26; i++) {
            if (graph[i].size() && !visited[i])
                return 0;
        }

        for (int i = 0; i < 26; i++)
            visited[i] = 0;

        dfs(start, transpose, visited);
        for (int i = 0; i < 26; i++) {
            if (transpose[i].size() && !visited[i])
                return 0;
        }

        return 1;
    }
};

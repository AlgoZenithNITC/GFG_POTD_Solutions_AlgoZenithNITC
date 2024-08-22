class graph {
  public:
    int V;
    list<int> *adj;

    graph(int V) {
        this->V = V;
        adj = new list<int>[V];
    }
    void addedge(int v, int u) { adj[v].push_back(u); }
};

class Solution {
  public:
    void dictorder(string str1, string str2, graph *g, int *exist) {
        int n1 = str1.size();
        int n2 = str2.size();

        for (int i = 0; i < n1; i++)
            exist[(int)str1[i]] = 1;
        for (int i = 0; i < n2; i++)
            exist[(int)str2[i]] = 1;

        int i = 0;
        while (i < n1 && i < n2) {
            if (str1[i] != str2[i]) {
                g->addedge((int)str1[i], (int)str2[i]);
                return;
            }
            i++;
        }
    }

    void topsort(list<int> *adj, bool *visited, stack<char> &st, int v, int *exist) {
        if (exist[v]) {
            visited[v] = true;
            for (auto u : adj[v])
                if (!visited[u])
                    topsort(adj, visited, st, u, exist);
            st.push((char)v);
        }
    }

    string findOrder(string dict[], int n, int k) {
        graph *g = new graph(256);
        int exist[256] = {0};

        for (int i = 1; i < n; i++) {
            dictorder(dict[i - 1], dict[i], g, exist);
        }
        bool visited[256] = {0};
        stack<char> st;
        for (int i = 0; i < 256; i++) {
            if (!visited[i])
                topsort(g->adj, visited, st, i, exist);
        }

        string final = "";
        while (!st.empty()) {
            final += st.top();
            st.pop();
        }

        return final;
    }
};

class Solution{
public: 
    bool dfs(int n, int k, int total_possibilities, string &path, set<string> &visited){
        if(visited.size() == total_possibilities){
            return true;
        }
        for(int i = 0; i < k; i++){
            string curr_node = path.substr(path.size() - n + 1);
            curr_node.push_back('0' + i);
            if(visited.find(curr_node) == visited.end()){
                visited.insert(curr_node);
                path.push_back('0' + i);
                if(dfs(n, k, total_possibilities, path, visited) == true){
                    return true;
                }
                path.pop_back();
                visited.erase(curr_node);
            }
        }
        return false;
    }
    string findString(int n, int k){
        string path = string(n - 1, '0');
        set<string> visited;
        int total_possibilities = pow(k, n);
        dfs(n, k, total_possibilities, path, visited);
        return path;
    }
};

class Solution{
    public boolean dfs(int n, int k, int total_possibilities, StringBuilder path, Set<String> visited){
        if(visited.size() == total_possibilities){
            return true;
        }
        for(int i = 0; i < k; i++){
            String curr_node = path.substring(path.length() - n + 1);
            curr_node += (char)('0' + i);
            if(!visited.contains(curr_node)){
                visited.add(curr_node);
                path.append((char)('0' + i));
                if(dfs(n, k, total_possibilities, path, visited)){
                    return true;
                }
                path.deleteCharAt(path.length() - 1);
                visited.remove(curr_node);
            }
        }
        return false;
    }
    public String findString(int n, int k){
       StringBuilder path = new StringBuilder();
        for(int i = 0; i < n - 1; i++){
            path.append('0');
        }
        Set<String> visited = new HashSet<>();
        int total_possibilities = (int)Math.pow(k, n);
        dfs(n, k, total_possibilities, path, visited);
        return path.toString();
    }
}

bool isValid(int i, int j, int m, int n){
    if(i < 0 || j < 0 || i >= m || j >= n)
        return false;
    return true;
}

int orangesRotting(vector<vector<int>>& arr) {
    // Code here
    int m = arr.size();
    int n = arr[0].size();
    
    queue <pair<int, int>> q;
    // vector <vector<int>> visited(m, vector<int>(n, 0));
    int count = 0;
    int count2 = 0;

    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(arr[i][j] == 2){
                q.push({i,j});
                // visited[i][j] = 1;
            }

            else if(arr[i][j] == 1)
                count2++;
        }
    }



    while(!q.empty()){
        // count++;
        int flag = 0;
        int z = q.size();

        while(z--){
            pair <int, int> temp = q.front();
            q.pop();
            bool a, b, c, d;
            int i = temp.first;
            int j = temp.second;
            // visited[i][j] = 1;
            a = isValid(temp.first, temp.second+1, m, n);
            b = isValid(temp.first, temp.second-1, m, n);
            c = isValid(temp.first+1, temp.second, m, n);
            d = isValid(temp.first-1, temp.second, m, n);

            if(a && arr[i][j+1] == 1){
                arr[i][j+1] = 2;
                q.push({i, j+1});
                flag = 1;
                count2--;
            }
            if(b && arr[i][j-1] == 1){
                arr[i][j-1] = 2;
                q.push({i, j-1});
                flag = 1;
                count2--;
            }
            if(c && arr[i+1][j] == 1){
                arr[i+1][j] = 2;
                q.push({i+1, j});
                flag = 1;
                count2--;
            }
            if(d && arr[i-1][j] == 1){
                arr[i-1][j] = 2;
                q.push({i-1, j});
                flag = 1;
                count2--;
            }
        }

        if(flag)
            count++;
    }

    // for(int i = 0; i < m; i++){
    //     for(int j = 0; j < n; j++)
    //         if(arr[i][j] == 1)
    //             return -1;
    // }

    if(count2 != 0)
        return -1;

    return count;
}

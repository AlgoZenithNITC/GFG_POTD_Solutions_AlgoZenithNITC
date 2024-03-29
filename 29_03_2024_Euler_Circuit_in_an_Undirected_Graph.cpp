class Solution {
public:
	bool isEularCircuitExist(int v, vector<int>adj[]){
	    // Code here
	    vector<int>deg(v, 0);
        for(int i = 0; i<v; i++)
        {
            for(auto it : adj[i])
            {
                deg[it]++;
            }
            
        }
        for(int i = 0; i<v; i++)
        {
            if(deg[i]%2!=0)
            {
                return false;
            }
        }
        return true;

	}

};

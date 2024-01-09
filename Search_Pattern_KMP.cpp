class Solution{
    public:
        void computeLPSArray(string pat, int M, vector <int>  &lps){
            int len = 0, i = 0;
            lps[0] = 0;
            i = 1;
            while (i < M){
                if (pat[i] == pat[len]){
                    len++;
                    lps[i] = len;
                    i++;
                }else{
                    if (len != 0){
                        len = lps[len - 1];
        
                    }else{
                        lps[i] = 0;
                        i++;
                    }
                }
            }
        }
        
        vector <int> search(string pat, string txt){
            vector <int> res;
            int M = pat.size();
            int N = txt.size();
            vector < int > lps(M + 1, 0);
            int j  = 0;
            computeLPSArray(pat, M, lps);
            int f = 0;
            int i = 0; 
            while (i < N){
                if(pat[j] == txt[i]){
                    j++;
                    i++;
                }
                if(j == M){
                    f++;
                    res.push_back (i - j + 1);
                    j = lps[j - 1];
                }
                else if(i < N && pat[j] != txt[i]){
                    if(j != 0){
                        j = lps[j - 1];
                    }else{
                        i = i + 1;
                    }
                }
            }
            if(f == 0){
                res.push_back (-1);
            }
            return res;
        }
};  

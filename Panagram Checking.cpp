class Solution
{
  public:
    //Function to check if a string is Pangram or not.
    bool checkPangram (string s) 
    {
    int a[26];
    for(int i=0;i<26;i++)
    {
        a[i]=0;
    }
    for(int i=0;s[i]!='\0';i++)
    {
        if(s[i]>=65 and s[i]<=90)
        {
            a[s[i]-65]++;
        }
        else if(s[i]>=97 and s[i]<=122)
        {
            a[s[i]-97]++;
        }
    }
    for(int i=0;i<26;i++)
    {
        if(a[i]==0)
        {
            return 0;
        }
    }
    return 1;
    }
};


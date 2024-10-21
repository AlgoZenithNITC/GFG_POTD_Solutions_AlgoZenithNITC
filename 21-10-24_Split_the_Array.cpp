#include<iostream>
#include<bits/stdc++.h>
    int countgroup(vector<int>& arr) 
    {
        int total_xor=arr[0];
        int n=arr.size();
        for(int i=1;i<n;i++)
        {
            total_xor = total_xor ^ arr[i];
        }
        if(total_xor!=0)
        {
            return 0;
        }
        return (1<<(n-1))-1;
        
    }
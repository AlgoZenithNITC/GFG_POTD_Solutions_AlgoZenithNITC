int countNumbers(int n) {
    // If any number (let X) can be expressed in terms of 
    // (p2 * q2) or (p8), where p and q are prime factors of X, 
    // then X has a total of 9 divisors.
    
    int ans = 0;
    
    int limit = sqrt(n);
    vector<int> sieve(limit+1);
    for(int i = 2; i <= limit; i++){
        sieve[i] = i;
    }
    for(int i = 2; i * i <= limit; i++){
        if(sieve[i] == i){
            for(int j = i*i; j <= limit; j += i){
                // Basically storing least prime factor of each element
                if(sieve[j] == j) sieve[j] = i;
            }
        }
    }
    
    for(int i = 2; i <= limit; i++){
        int p = sieve[i];
        int q = sieve[i/p];
        
        if(p*q == i && q != 1 && p != q)
            ans++;
        else if(sieve[i] == i && pow(i, 8) <= n)
            ans++;
    }
    
    return ans;
}

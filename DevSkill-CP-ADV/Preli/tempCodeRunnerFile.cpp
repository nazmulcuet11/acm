    dp[0] = primes[0];
    for(int i = 1; i < primes.size(); i++) {
        dp[i] = (dp[i-1] * primes[i]) % MOD;
    }
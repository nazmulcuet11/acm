#include <iostream>
#include <vector>
#include <cmath>
#include <queue>

using namespace std;

#define MAX_PRIME 40+5
#define MAX_N 1020

vector<int> factors[MAX_N];
vector<int> primes;

void calculate_primes() {
    bool is_prime[MAX_PRIME];
    for(int i = 0; i < MAX_PRIME; i++)
        is_prime[i] = true;

    for(int i=2; i<=sqrt(MAX_PRIME)+1; i++)
        if(is_prime[i])
            for(int j=i+i; j<MAX_PRIME; j+=i)
                is_prime[j] = false;

    for(int i=2; i<MAX_PRIME; i++)
        if(is_prime[i])
            primes.push_back(i);
}

void factorize(int n) {
    int temp = n;
    for(int i=0; primes[i]<= sqrt(n)&& i<primes.size(); i++)
        if(n % primes[i] == 0) {
            while(n % primes[i] == 0)
                n /= primes[i];

            factors[temp].push_back(primes[i]);
        }

    if(n>1 && n != temp)
        factors[temp].push_back(n);
}

int bfs(int start, int dest)
{
    int cnt[MAX_N];
    for(int i = 0; i < MAX_N; i++)
        cnt[i] = -1;

    queue<int> q;
    q.push(start);
    cnt[start] = 0;

    while(!q.empty()) {
        int temp = q.front(); q.pop();
        if(temp == dest) return cnt[temp];

        for(int i=0; i<factors[temp].size(); i++) {
            int new_val = temp + factors[temp][i];
            if(new_val > dest || cnt[new_val] != -1)
                continue;

            cnt[new_val] = cnt[temp] + 1;
            q.push(new_val);
        }
    }

    return -1;
}

int main(int argc, char const *argv[])
{
    calculate_primes();
    for(int i=1; i< MAX_N; i++) 
        factorize(i);

    int t;
    cin >> t;
    for(int case_no = 1; case_no <=t; case_no++)
    {
        int start, dest;
        cin >> start >> dest;
        cout << "Case " << case_no << ": " << bfs(start, dest) << "\n";
    }
    return 0;
}

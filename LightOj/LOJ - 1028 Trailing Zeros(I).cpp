#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <vector>
#include <cmath>

using namespace std;

bool flag[1000000+10];
//vector <int> prime;
long long int prime[80000],total_prime=0;

void seive()
{
    memset(flag,true,sizeof flag);
    for(int i=2;i<sqrt(1000010)+1;i++)
        if(flag[i])
            for(int j=i+i;j<1000010;j+=i)
                flag[j]=false;

    prime[total_prime++]=2;
    for(int i=3;i<1000010;i+=2)
        if(flag[i])
            prime[total_prime++]=i;
}
long long int solve(long long int N)
{
    long long int val=sqrt(N)+1;
    long long int ans=1,count;
    for(int i=0;i<total_prime&&prime[i]<(sqrt(N)+1);i++)
    {
        if(N%prime[i]==0)
        {
            count=0;
            while(N%prime[i]==0)
            {
                count++;
                N/=prime[i];
            }
            ans*=(count+1);
        }
    }
    if(N>1)
        ans*=2;
    return ans;
}

int main()
{
    seive();
    long long int test_case,case_no=1,N;
    for(scanf("%lld",&test_case);test_case;test_case--)
    {
        scanf("%lld",&N);
        printf("Case %lld: %lld\n",case_no++,solve(N)-1);
    }
    return 0;
}

#include <iostream>
#include <cstring>
#include <cstdio>
using namespace std;
long long int prime[1000005]= {0};
long long int dp[1000005]= {0};
long long int disit_prime[1000005]= {0};
void prime_generator()
{
    for(long long int i=3; i<1000005; i+=2)
        prime[i]=1;
    prime[2]=1;
    for(long long int i=3; i<1000; i+=2)
    {
        for(long long int j=i*3; j<1000005; j=j+i)
            prime[j]=0;
    }
    return;
}
long long int sum_disit(long long int i)
{
    if(i<=0)
        return 0;
    if(dp[i]!=0)
        return dp[i];
    return dp[i]=i%10+sum_disit(i/10);
}
void disitprime()
{
    int count=0;
    for(long long int i=0; i<=1000002; i++)
    {
        if(prime[i]&&prime[sum_disit(i)])
            count++;
        disit_prime[i]=count;
    }
}
int main()
{
    prime_generator();
    disitprime();
    long long int n,t1,t2,count,sum;
    scanf("%lld",&n);
    while(n--)
    {
        scanf("%lld %lld",&t1,&t2);
        count=disit_prime[t2]-disit_prime[t1-1];
        printf("%lld\n",count);
    }
    return 0;
}

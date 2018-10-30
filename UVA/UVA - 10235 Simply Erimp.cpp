#include <iostream>
#include <stdio.h>

using namespace std;

int prime[1000003]= {0};
int main()
{
    int i,j;
    for(int i=1; i<=1000003; i+=2)
        prime[i]=1;
    prime[2]=1;
    for(i=3; i<=1001; i+=2)
        for(j=i*3; j<=1000003; j+=i)
            prime[j]=0;

    long long int a,b,c;
    while(scanf("%lld",&a)==1)
    {
        if(prime[a]==0)
        {
            printf("%lld is not prime.\n",a);
            continue;
        }

        if(a<=9&&prime[a]==1)
        {
            printf("%d is prime.\n",a);
            continue;
        }

        b=0;
        c=a;
        while(c>9)
        {
            b=b*10+c%10;
            c=c/10;
        }
        b=b*10+c;

        if(prime[b]==1&&a!=b)
        printf("%lld is emirp.\n",a);

        else if(prime[b]==1&&a==b)
        printf("%lld is prime.\n",a);

        else if(prime[b]==0)
        printf("%lld is prime.\n",a);
    }
    return 0;
}

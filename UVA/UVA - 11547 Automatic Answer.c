#include<stdio.h>

int main()
{
    long long int i,n,t,m,d;
    scanf("%lld",&t);
    for(i=0; i<t; i++)
    {
        m=0;
        scanf("%lld",&n);
        m=(((((n*567)/9)+7492)*235)/47)-498;
        if(m<0)
            m=-1*m;
        m=m/10;
        m=m%10;
        printf("%lld\n",m);
    }

}

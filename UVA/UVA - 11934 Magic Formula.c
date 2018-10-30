#include <stdio.h>
int main()
{
    long long int a,b,c,d,l,n,sum,count;
    while(scanf("%lld %lld %lld %lld %lld",&a,&b,&c,&d,&l)==5)
    {
        sum=0;
        count=0;
        if(a==0&&b==0&&c==0&&d==0&&l==0)
            break;
        else
        {
            for(n=0; n<=l; n++)
            {
                sum=a*n*n+b*n+c;

                if(sum%d==0)
                count++;
            }
            printf("%lld\n",count);
        }
    }
    return 0;
}

#include<stdio.h>

int main()
{
   long long int n;
    while(scanf("%lld",&n)==1)
    {
        if(n<0)
            break;
        else
        {
       		long long int i,t=1;
                for(i=1; i<=n; i++)
                {
                    t=t+i;
                }
                printf("%lld\n",t);
           }
    }
    return 0;
}

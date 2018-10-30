#include<stdio.h>

int main()
{
    long int n;
    while(scanf("%ld",&n)==1)
    {
        if(n==0)
            break;
        else
        {
            if(n<=9)
                printf("%ld\n",n);
            else
            {
                while(n>9)
                {
                    int t,sum=0;
                    while(n>9)
                    {
                        t=n%10;
                        sum=t+sum;
                        n=n/10;
                    }
                    n=sum+n;

                }
                printf("%ld\n",n);
            }
        }
    }
    return 0;
}

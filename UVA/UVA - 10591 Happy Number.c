#include<stdio.h>

int main()
{
    long long i,j,k,d,sum,num,t,n;
    scanf("%lld",&t);

    for(k=1; k<=t; k++)
    {
        scanf("%lld",&n);
        num=n;
        do
        {
            sum=0;
            do
            {
                d=num%10;
                num=num/10;
                sum=sum+d*d;
            }
            while(num!=0);
            num=sum;
        }
        while(num>9);

        if(num==1)
            printf("Case #%lld: %lld is a Happy number.\n",k,n);
        else
            printf("Case #%lld: %lld is an Unhappy number.\n",k,n);
    }
    return 0;
}


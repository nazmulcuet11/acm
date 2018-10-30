#include <stdio.h>

int main()
{
    int a,b,k,l,sum,n;
    while(scanf("%d%d",&a,&b)==2)
    {
        n=a;
        sum=0;
        while(a>=b)
        {

            k=a/b;
            l=a%b;
            sum=sum+k;
            a=k+l;
        }
        printf("%d\n",sum+n);
    }
    return 0;
}

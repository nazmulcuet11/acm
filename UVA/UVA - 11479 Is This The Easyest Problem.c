#include<stdio.h>

int main()
{
    int t;
    while(scanf("%d",&t)==1)
    {
        int i;
        for(i=0; i<t; i++)
        {
            long int a,b,c;
            scanf("%ld%ld%ld",&a,&b,&c);

            if((a+b)<=c||(b+c)<=a||(c+a)<=b)
                printf("Case %d: Invalid\n",i+1);

            else if(a==b&&b==c)
                printf("Case %d: Equilateral\n",i+1);

            else if((a==b&&b!=c)||(a==c&&a!=b)||(b==c&&c!=a))
                printf("Case %d: Isosceles\n",i+1);

            else if(a!=b&&b!=c&&a!=c)
                printf("Case %d: Scalene\n",i+1);
        }
    }
    return 0;
}

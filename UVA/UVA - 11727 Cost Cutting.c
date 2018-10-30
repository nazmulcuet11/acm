#include<stdio.h>

int main()
{
    int t;
    int a,b,c;
    int i;

    while(scanf("%d",&t)==1)
    {
        for(i=1; i<=t; i++)
        {
            scanf("%d%d%d",&a,&b,&c);

            if(a>b&&a>c)
            {
                if(b>c)
                    printf("Case %d: %d\n",i,b);
                if(c>b)
                    printf("Case %d: %d\n",i,c);
            }


            else if(b>c)
            {
                if(a>c)
                    printf("Case %d: %d\n",i,a);
                if(c>a)
                    printf("Case %d: %d\n",i,c);
            }


            else
            {
                if(a>b)
                    printf("Case %d: %d\n",i,a);
                if(b>a)
                    printf("Case %d: %d\n",i,b);
            }
        }

    }
}




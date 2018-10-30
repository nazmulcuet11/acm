#include<stdio.h>

int main()
{
    int n,i,j,x,y;
    while(scanf("%d",&n)==1)
    {
        if(n==0)
            break;

        else
        {
            for(i=0; i<n; i++)
            {
                for(j=0; j<i; j++)
                {
                    x=j*j*j;
                    y=i*i*i;

                    if((y-x)==n)
                    {
                        printf("%d %d\n",i,j);
                        break;
                    }

                }
                if((y-x)==n)
                    break;

            }
            if((y-x)!=n)
                printf("No solution\n");
        }
    }
    return 0;
}

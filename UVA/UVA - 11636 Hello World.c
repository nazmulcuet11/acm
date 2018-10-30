#include<stdio.h>

int main()
{
    int n,count,j=0,i;

    while(scanf("%d",&n)==1)
    {
        if(n<=0)
            break;

        else
        {
    count=0;
            for(i=1; i<n;)
            {
                i=i+i;
                count++;
            }
            j++;
            printf("Case %d: %d\n",j,count);
        }
    }
    return 0;
}

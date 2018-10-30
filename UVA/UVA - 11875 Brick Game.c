#include<stdio.h>

int main()
{
    int i,t,j,n,a[11];
    scanf("%d",&t);

    for(i=1; i<=t; i++)
    {
        scanf("%d",&n);

        for(j=1; j<=n; j++)
        {
            scanf("%d",&a[j]);
        }
        printf("Case %d: %d\n",i,a[(n-1)/2+1]);
    }
}


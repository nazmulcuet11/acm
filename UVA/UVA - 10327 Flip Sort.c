#include<stdio.h>

int main()
{
    int i,j,n,k,count,a[50000];

    while(scanf("%d",&n)!=EOF)
    {
        count=0;
        for(i=0; i<n; i++)
        {
            scanf("%d",&a[i]);
        }

        for(i=0; i<n-1; i++)
        {
            for(j=0; j<n-1-i; j++)
            {
                if(a[j]>a[j+1])
                {
                    k=a[j+1];
                    a[j+1]=a[j];
                    a[j]=k;
                    count++;
                }
            }
        }

        printf("Minimum exchange operations : %d\n",count);
    }
    return 0;
}




#include <stdio.h>
int main()
{
    int t,i,n,j,a[50000],temp,flag,k;
    scanf("%d",&t);
    for(i=0; i<t; i++)
    {
        flag=0;
        scanf("%d",&n);
        for(j=0; j<n; j++)
        {
            scanf("%d",&a[j]);
        }

        for(j=0; j<n-1; j++)
        {
            for(k=0; k<n-1-j; k++)
            {
                if(a[k]>a[k+1])
                {
                    temp=a[k+1];
                    a[k+1]=a[k];
                    a[k]=temp;
                    flag++;
                }
            }
        }

        printf("Optimal train swapping takes %d swaps.\n",flag);
    }
    return 0;
}

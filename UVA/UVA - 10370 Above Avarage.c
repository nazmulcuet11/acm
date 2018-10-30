#include<stdio.h>

int main()
{
    int t,i,c,k;
    float avg,per,sum,count;
    scanf("%d",&t);
    for(i=0; i<t; i++)
    {
        scanf("%d",&c);
        int a[c];
        sum=0;
        count=0;
        for(k=0; k<c; k++)
        {
            scanf("%d",&a[k]);
            sum=sum+a[k];
        }
        avg=sum/c;
        for(k=0; k<c; k++)
        {

            if(a[k]>avg)
                count=count+1;
        }
        per=(count/c)*100;
        printf("%0.3f%%\n",per);
    }
}

#include<stdio.h>
#include<string.h>

int c,d,i,n,l,m,sum1,sum2,total,j;
char a[500];
char b[500];

int cal(int sum)
{
    while(sum>9)
    {
       total=0;
        while(sum>9)
        {
            j=sum%10;
            sum=sum/10;

            total=total+j;
        }
        sum=total+sum;
    }

    return sum;
}

int main()
{

while(gets(a))
    {
        gets(b);
        sum1=0;
        sum2=0;
        total=0;
        n=strlen(a);
        m=strlen(b);

        for(i=0; i<n; i++)
        {
            l=a[i];
            if(l>=65&&l<=90)
                l=l-64;

            else if(l>=97&&l<=122)
                l=l-96;

            else
                l=0;

            sum1=sum1+l;
        }
        c=cal(sum1);
        for(i=0; i<m; i++)
        {
            l=b[i];
            if(l>=65&&l<=90)
                l=l-64;

            else if(l>=97&&l<=122)
                l=l-96;

            else
                l=0;

            sum2=sum2+l;
        }
        d=cal(sum2);

        if(c>d)
            printf("%.2lf %%\n",((float)d/(float)c)*100);
        else
            printf("%.2lf %%\n",((float)c/(float)d)*100);

    }
    return 0;
}

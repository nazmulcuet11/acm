#include<stdio.h>

long int i,j,n,count,res,ref,t,p,q;

long int cal(long int j)
{
    count=1;
    while(j!=1)
    {
        if(j%2==0)
            j=j/2;

        else
            j=j*3+1;
        count++;
    }
    return count;
}

int main()
{

    while(scanf("%ld%ld",&i,&n)==2)
    {
        p=i;
        q=n;
        ref=1;
        if(p>q)
        {
            t=p;
            p=q;
            q=t;
        }

        if(p==1&&q==1)
            printf("1 1 1\n");

        else
        {
            for(j=p; j<=q; j++)
            {
                if(j==1)
                    j=2;

                res=cal(j);
                if(res>ref)
                    ref=res;
            }

            printf("%ld %ld %ld\n",i,n,ref);
        }
    }
    return 0;
}

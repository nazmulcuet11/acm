#include<stdio.h>

int i,j,N;
long long int G;

int GCD(int i,int j)
{
    int k;
    while(i!=0)
    {
        k=j%i;
        j=i;
        i=k;
    }
    return j;
}
int  main()
{
    while(scanf("%d",&N)==1)
    {
        if(N==0)
        break;
        G=0;
        for(i=1; i<N; i++)
            for(j=i+1; j<=N; j++)
                {
                    G+=GCD(i,j);
                }
            printf("%lld\n",G);
    }
    return 0;
}

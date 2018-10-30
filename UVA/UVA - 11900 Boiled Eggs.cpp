#include <iostream>
#include <stdio.h>
#include <algorithm>

using namespace std;

int main()
{
    int testcase,n,p,q,w[33],t,count,j=1;
    scanf("%d",&testcase);
    while(testcase--)
    {
        t=0;
        count=0;
        scanf("%d%d%d",&n,&p,&q);

        for(int i=0;i<n;i++)
        {
            scanf("%d",&w[i]);
        }

        sort(w,w+n);

        for(int i=0;i<min(n,p);i++)
        {
            t+=w[i];

            if(t>q)
            break;

            count++;
        }

        printf("Case %d: %d\n",j,count);
        j++;
    }
    return 0;
}

#include <iostream>
#include <cstdio>
#include <vector>
#include <cstring>
#include <cmath>

using namespace std;

bool flag[32768+5];

void seive()
{
    memset(flag,true,sizeof flag);

    for(int i=2;i<sqrt(32768)+1;i++)
        if(flag[i])
            for(int j=i+i;j<=32768;j+=i)
                flag[j]=false;
}

int main()
{
    seive();
    int n,count;
    while(scanf("%d",&n)==1&&n)
    {
        count=0;
        for(int i=2;i<=n/2;i++)
            if(flag[i]&&flag[n-i])
                count++;
        printf("%d\n",count);
    }
    return 0;
}

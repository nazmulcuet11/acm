#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

int prime[1000005]= {0};
vector<int>v;
int main()
{
    int i,j,k,n,dif;

    for(i=3; i<1000005; i+=2)
        prime[i]=1;

    for(i=3; i<1000; i+=2)
    {
        for(j=i*3; j<1000005; j=j+i)
            prime[j]=0;
    }

    for(i=3; i<1000005; i+=2)
    {
        if(prime[i]!=0)
            v.push_back(i);
    }

    while(scanf("%d",&n)==1)
    {
        if(n==0)
        break;

        for(i=0;i<v.size();i++)
        {
            dif=n-v[i];
            if(prime[dif]==1)
            {
                printf("%d = %d + %d\n",n,v[i],dif);
                break;
            }
            continue;
        }
    }
    return 0;
}

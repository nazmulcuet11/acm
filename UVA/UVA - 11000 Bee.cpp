#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    long long int n,male,total,male_prev;
    while(scanf("%lld",&n)==1)
    {
        if(n==-1)
            break;

        male=0;
        total=1;

        for(int i=1; i<=n; i++)
        {
            if(i==1)
            {
                male=1;
                total=2;
            }
            else
            {
                male_prev=male;
                male=total;
                total=total+male_prev+1;
            }
        }

        printf("%lld %lld\n",male,total);
    }
    return 0;
}

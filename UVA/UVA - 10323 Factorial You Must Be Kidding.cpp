#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    long long int i,n,fact;
    while(scanf("%lld",&n)!=EOF)
    {
        fact=1;
        if(n<0)
        {
            n=n*(-1);

            if(n%2==0)
            cout<<"Underflow!"<<endl;

            else
            cout<<"Overflow!"<<endl;

            continue;
        }

        if(n<8)
        {
            cout<<"Underflow!"<<endl;
            continue;
        }

        else if(n>13)
        {
            cout<<"Overflow!"<<endl;
            continue;
        }

        else
        {
            for(i=2; i<=n; i++)
                fact*=i;
            cout<<fact<<endl;
        }
    }
    return 0;
}

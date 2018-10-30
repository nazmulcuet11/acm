#include <iostream>
#include <stdio.h>
#include <stack>

using namespace std;

int main()
{
    long long int n;
    stack<int>s;
    while(scanf("%lld",&n)==1)
    {
        if(n<0)
        break;

        if(n==0)
        {
            cout<<"0"<<endl;
            continue;
        }

        while(n>=1)
        {
            s.push(n%3);
            n=n/3;
        }

        while(!s.empty())
        {
            cout<<s.top();
            s.pop();
        }

        cout<<endl;
    }
    return 0;
}

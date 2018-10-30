#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    long long int n;
    while(scanf("%lld",&n)!=EOF)
    {
        n=((n*(n+2))/2)*3-6;
        cout<<n<<endl;
    }
    return 0;
}
